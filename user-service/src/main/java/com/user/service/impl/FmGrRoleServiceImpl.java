package com.user.service.impl;

import com.user.client.base.CommonResult;
import com.user.client.domain.FmGrAcbDO;
import com.user.client.domain.FmGrActDO;
import com.user.client.domain.FmGrRoleDO;
import com.user.client.domain.FmGrRoleMDO;
import com.user.client.query.FmGrAcbQueryDO;
import com.user.client.query.FmGrActQueryDO;
import com.user.client.query.FmGrRoleMQueryDO;
import com.user.client.query.FmGrRoleQueryDO;
import com.user.client.query.ext.FmGrRoleQueryExt;
import com.user.dao.FmGrAcbDao;
import com.user.dao.FmGrActDao;
import com.user.dao.FmGrRoleDao;
import com.user.dao.FmGrRoleMDao;
import com.user.service.FmGrRoleService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FmGrRoleServiceImpl extends BaseServiceAOImpl<FmGrRoleDO, FmGrRoleQueryDO> implements FmGrRoleService {

    @Resource
    private FmGrRoleDao baseDao;

    @Resource
    private FmGrActDao fmGrActDao;
    @Resource
    private FmGrAcbDao fmGrAcbDao;
    @Resource
    private FmGrRoleMDao fmGrRoleMDao;

    @Override
    public BaseDAO<FmGrRoleDO, FmGrRoleQueryDO> getDAO() {
        return baseDao;
    }

    @Override
    public List<FmGrRoleDO> listByRoleIds(List<Long> roleIds) throws Exception {
        FmGrRoleQueryExt queryExt = new FmGrRoleQueryExt();
        queryExt.setRoleIds(roleIds);
        List<FmGrRoleDO> fmGrRoleDOS = baseDao.listByRoleIds(queryExt);
        return fmGrRoleDOS;
    }

    @Override
    public CommonResult<List<FmGrRoleDO>> listByUrl(String url) throws Exception {
        log.info("请求url获取包含角色，url={}", url);
        FmGrActQueryDO actQueryDO = new FmGrActQueryDO();
        actQueryDO.setPath(url);
        List<FmGrActDO> fmGrActDOS = fmGrActDao.queryList(actQueryDO);
        if (CollectionUtils.isEmpty(fmGrActDOS)) {
            log.warn("请求url未配置到action！url={}", url);
            return CommonResult.successReturn(null);
        }
        List<Long> actionIds = fmGrActDOS.stream().map(fmGrActDO -> fmGrActDO.getActionId()).collect(Collectors.toList());
        FmGrAcbQueryDO acbQueryDO = new FmGrAcbQueryDO();
        acbQueryDO.setActionIds(actionIds);
        List<FmGrAcbDO> fmGrAcbDOS = fmGrAcbDao.queryList(acbQueryDO);
        if (CollectionUtils.isEmpty(fmGrAcbDOS)) {
            log.warn("请求url未绑定到按钮！url={}", url);
            return CommonResult.successReturn(null);
        }
        List<Long> menuIds = fmGrAcbDOS.stream().map(fmGrAcbDO -> fmGrAcbDO.getMenuId()).collect(Collectors.toList());
        List<Long> disMenuIds = menuIds.stream().distinct().collect(Collectors.toList());
        FmGrRoleMQueryDO fmGrRoleMQueryDO = new FmGrRoleMQueryDO();
        fmGrRoleMQueryDO.setMenuIds(disMenuIds);
        List<FmGrRoleMDO> fmGrRoleMDOS = fmGrRoleMDao.queryList(fmGrRoleMQueryDO);
        if (CollectionUtils.isEmpty(fmGrRoleMDOS)) {
            log.warn("请求url绑定菜单未绑定到角色！url={}", url);
            return CommonResult.successReturn(null);
        }
        List<Long> roleIds = fmGrRoleMDOS.stream().map(fmGrRoleMDO -> fmGrRoleMDO.getRoleId()).collect(Collectors.toList());
        List<Long> disRoleIds = roleIds.stream().distinct().collect(Collectors.toList());
        FmGrRoleQueryExt queryExt = new FmGrRoleQueryExt();
        queryExt.setRoleIds(disRoleIds);
        List<FmGrRoleDO> fmGrRoleDOS = baseDao.listByRoleIds(queryExt);
        return CommonResult.successReturn(fmGrRoleDOS);
    }
}
