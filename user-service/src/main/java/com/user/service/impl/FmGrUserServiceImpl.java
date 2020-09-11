package com.user.service.impl;
import com.user.client.base.CommonResult;
import com.user.client.domain.FmGrDeptDO;
import com.user.client.domain.FmGrRoleDO;
import com.user.client.domain.FmGrUserDO;
import com.user.client.domain.FmGrUserRDO;
import com.user.client.query.FmGrUserQueryDO;
import com.user.client.vo.FmGrMenuVO;
import com.user.client.vo.FmGrUserVO;
import com.user.dao.FmGrUserDao;
import com.user.service.FmGrDeptService;
import com.user.service.FmGrMenuService;
import com.user.service.FmGrUserRService;
import com.user.service.FmGrUserService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FmGrUserServiceImpl extends BaseServiceAOImpl<FmGrUserDO, FmGrUserQueryDO> implements FmGrUserService {

    @Resource
    private FmGrUserDao baseDao;
    @Resource
    private FmGrUserRService fmGrUserRService;
    @Resource
    private FmGrRoleServiceImpl fmGrRoleService;
    @Resource
    private FmGrDeptService fmGrDeptService;
    @Resource
    private FmGrMenuService fmGrMenuService;


    @Override
    public BaseDAO<FmGrUserDO, FmGrUserQueryDO> getDAO() {
        return baseDao;
    }

    @Override
    public CommonResult<FmGrUserVO> getByUserName(String userName) throws Exception {
        FmGrUserQueryDO queryDO = new FmGrUserQueryDO();
        queryDO.setMobile(userName);
        List<FmGrUserDO> fmGrUserDOS = baseDao.queryList(queryDO);
        if(CollectionUtils.isEmpty(fmGrUserDOS)){
            log.info("根据用户名查询返回结果 为 Null,userName = {}",userName);
            return CommonResult.successReturn(null);
        }
        FmGrUserVO vo = new FmGrUserVO();
        BeanUtils.copyProperties(fmGrUserDOS.get(0),vo);
        Long userId = vo.getUserId();
        List<FmGrUserRDO> fmGrUserRDOS = fmGrUserRService.listByUserId(userId);
        if(!CollectionUtils.isEmpty(fmGrUserRDOS)){
            List<Long> roleIds = fmGrUserRDOS.stream().map(fmGrUserRDO -> fmGrUserRDO.getRoleId()).collect(Collectors.toList());
            List<FmGrRoleDO> fmGrRoleDOS = fmGrRoleService.listByRoleIds(roleIds);
            vo.setRoleDOS(fmGrRoleDOS);
            //获取菜单
           // List<FmGrMenuVO> grMenuVOS = fmGrMenuService.getByRoleIds(roleIds);
           // vo.setMenuVOS(grMenuVOS);
            List<String> permissionByRoleIds = fmGrMenuService.getPermissionByRoleIds(roleIds);
           // vo.setPermissionList(permissionByRoleIds);
        }
        //获取部门
        List<FmGrDeptDO> deptDOS = fmGrDeptService.getByUserId(userId);
        vo.setFmGrDeptDOS(deptDOS);

        return CommonResult.successReturn(vo);
    }
}
