package com.user.service.impl;

import com.user.client.base.CommonResult;
import com.user.client.domain.*;
import com.user.client.query.*;
import com.user.client.query.ext.FmGrRoleQueryExt;
import com.user.dao.*;
import com.user.service.FmGrActService;
import com.user.service.FmGrMenuBtnService;
import com.user.service.FmGrMenuService;
import com.user.service.FmGrRoleService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @Resource
    private FmGrUserRDao fmGrUserRDao;
    @Resource
    private FmGrMenuService fmGrMenuService;
    @Resource
    private FmGrMenuBtnService fmGrMenuBtnService;
    @Resource
    private FmGrActService fmGrActService;

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

    @Override
    public List<FmGrRoleDO> listByUserId(Long userId) throws Exception {
        FmGrUserRQueryDO queryDO = new FmGrUserRQueryDO();
        queryDO.setUserId(userId);
        List<FmGrUserRDO> fmGrUserRDOS = fmGrUserRDao.queryList(queryDO);
        if (!CollectionUtils.isEmpty(fmGrUserRDOS)) {
            List<Long> roleIds = fmGrUserRDOS.stream().map(fmGrUserRDO -> fmGrUserRDO.getRoleId()).collect(Collectors.toList());
            List<FmGrRoleDO> fmGrRoleDOS = listByRoleIds(roleIds);
            return fmGrRoleDOS;
        }
        return null;
    }

    @Override
    public Map<Long, List<String>> allPath() throws Exception {
        Map<Long, List<String>> longListMap = new HashMap<>();

        FmGrRoleMQueryDO roleMQueryDO = new FmGrRoleMQueryDO();
        List<FmGrRoleMDO> fmGrRoleMDOS = fmGrRoleMDao.queryList(roleMQueryDO);
        if (CollectionUtils.isEmpty(fmGrRoleMDOS)) {
            return longListMap;
        }
        Map<Long, List<FmGrRoleMDO>> mMap = fmGrRoleMDOS.stream().collect(Collectors.groupingBy(FmGrRoleMDO::getRoleId));
        for (Long key : mMap.keySet()) {
            List<FmGrRoleMDO> fmGrRoleMDOS1 = mMap.get(key);
            List<Long> roleIds = fmGrRoleMDOS1.stream().map(fmGrRoleMDO -> fmGrRoleMDO.getRoleId()).collect(Collectors.toList());
            List<FmGrMenuDO> fmGrMenuDOS = fmGrMenuService.getDOByRoleIds(roleIds);
            List<String> strings = longListMap.get(key);
            if (!CollectionUtils.isEmpty(fmGrMenuDOS)) {
                List<String> newString = fmGrMenuDOS.stream().map(FmGrMenuDO::getUrl).collect(Collectors.toList());
                List<String> distinctNewString = newString.stream().distinct().collect(Collectors.toList());

                if(CollectionUtils.isEmpty(strings)){
                    longListMap.put(key,distinctNewString);
                }else {
                    strings.addAll(distinctNewString);
                    longListMap.put(key,strings);
                }
                //按钮
                List<Long> menuIds = fmGrRoleMDOS1.stream().map(fmGrRoleMDO -> fmGrRoleMDO.getMenuId()).collect(Collectors.toList());
                List<FmGrMenuBtnDO> listByMenuIds = fmGrMenuBtnService.getListByMenuIds(menuIds);
                if(!CollectionUtils.isEmpty(listByMenuIds)){
                    List<Long> btnIds = listByMenuIds.stream().map(fmGrMenuBtnDO -> fmGrMenuBtnDO.getBtnId()).collect(Collectors.toList());
                    List<FmGrActDO> listByBtnIds = fmGrActService.getListByBtnIds(btnIds);
                    if(!CollectionUtils.isEmpty(listByBtnIds)){
                        List<String> paths = listByBtnIds.stream().map(fmGrActDO -> fmGrActDO.getPath()).collect(Collectors.toList());
                        if(CollectionUtils.isEmpty(strings)){
                            longListMap.put(key,paths);
                        }else {
                            strings.addAll(paths);
                            longListMap.put(key,strings);
                        }
                    }
                }
            }

        }

        return longListMap;
    }
}
