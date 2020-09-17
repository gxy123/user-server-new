package com.user.service.impl;

import com.user.client.domain.*;
import com.user.client.query.*;
import com.user.client.vo.FmGrMenuVO;
import com.user.dao.*;
import com.user.service.FmGrMenuService;
import com.user.service.FmGrRoleService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FmGrMenuServiceImpl extends BaseServiceAOImpl<FmGrMenuDO, FmGrMenuQueryDO> implements FmGrMenuService {

    @Resource
    private FmGrMenuDao baseDao;
    @Resource
    private FmGrRoleMDao fmGrRoleMDao;
    @Resource
    private FmGrMenuBtnDao fmGrMenuBtnDao;
    @Resource
    private FmGrAcbDao fmGrAcbDao;
    @Resource
    private FmGrActDao fmGrActDao;


    @Override
    public BaseDAO<FmGrMenuDO, FmGrMenuQueryDO> getDAO() {
        return baseDao;
    }

    @Override
    public List<FmGrMenuVO> getByRoleIds(List<Long> roleIds) throws Exception {
        List<FmGrMenuVO> fmGrMenuVOS =new ArrayList<>();
        List<FmGrMenuDO> m = getDOByRoleIds(roleIds);
        List<Long> menuIds = m.stream().map(menuDO -> menuDO.getMenuId()).collect(Collectors.toList());
        FmGrMenuBtnQueryDO fmGrMenuBtnQueryDO = new FmGrMenuBtnQueryDO();
        fmGrMenuBtnQueryDO.setMenuIds(menuIds);
        List<FmGrMenuBtnDO> fmGrMenuBtnDOS = null;
        Map<Long, List<FmGrMenuBtnDO>> MapBtns = new HashMap<>();
        try {
            fmGrMenuBtnDOS = fmGrMenuBtnDao.queryList(fmGrMenuBtnQueryDO);
            if (!CollectionUtils.isEmpty(fmGrMenuBtnDOS)) {
                MapBtns = fmGrMenuBtnDOS.stream().collect(Collectors.groupingBy(FmGrMenuBtnDO::getMenuId));
            }
        } catch (Exception e) {
            log.error("获取菜单按钮配置异常！");
        }
        Map<Long, List<FmGrMenuBtnDO>> finalMapBtns = MapBtns;//按钮list
        m.forEach(fmGrMenuDO -> {
            Long menuId = fmGrMenuDO.getMenuId();
            FmGrMenuVO vo = new FmGrMenuVO();
            BeanUtils.copyProperties(fmGrMenuDO, vo);
            vo.setBtnVOList(finalMapBtns.get(menuId) );
            fmGrMenuVOS.add(vo);
        });
        return fmGrMenuVOS;
    }

    @Override
    public List<FmGrMenuDO> getDOByRoleIds(List<Long> roleIds) throws Exception {
        FmGrRoleMQueryDO fmGrRoleMQueryDO = new FmGrRoleMQueryDO();
        fmGrRoleMQueryDO.setRoleIds(roleIds);
        List<FmGrRoleMDO> fmGrRoleMDOS = fmGrRoleMDao.queryList(fmGrRoleMQueryDO);
        if (CollectionUtils.isEmpty(fmGrRoleMDOS)) {
            log.error("未找到角色菜单配置！");
            return null;
        }
        List<Long> menuIds = fmGrRoleMDOS.stream().map(fmGrRoleMDO -> fmGrRoleMDO.getMenuId()).collect(Collectors.toList());
        FmGrMenuQueryDO fmGrMenuQueryDO = new FmGrMenuQueryDO();
        fmGrMenuQueryDO.setMenuIds(menuIds);
        List<FmGrMenuDO> fmGrMenuDOS = baseDao.queryList(fmGrMenuQueryDO);
       return fmGrMenuDOS;
    }

    @Override
    public List<String> getPermissionByRoleIds(List<Long> roleIds) throws Exception {
        List<String> permissionList =new ArrayList<>();
        FmGrRoleMQueryDO fmGrRoleMQueryDO = new FmGrRoleMQueryDO();
        fmGrRoleMQueryDO.setRoleIds(roleIds);
        List<FmGrRoleMDO> fmGrRoleMDOS = fmGrRoleMDao.queryList(fmGrRoleMQueryDO);
        if (CollectionUtils.isEmpty(fmGrRoleMDOS)) {
            log.error("未找到角色菜单配置！");
            return null;
        }
        List<Long> menuIds = fmGrRoleMDOS.stream().map(fmGrRoleMDO -> fmGrRoleMDO.getMenuId()).collect(Collectors.toList());
        FmGrMenuQueryDO fmGrMenuQueryDO = new FmGrMenuQueryDO();
        fmGrMenuQueryDO.setMenuIds(menuIds);
        List<FmGrMenuDO> fmGrMenuDOS = baseDao.queryList(fmGrMenuQueryDO);
        if (CollectionUtils.isEmpty(fmGrMenuDOS)) {
            log.error("未找到菜单项！");
            return null;
        }
        FmGrMenuBtnQueryDO fmGrMenuBtnQueryDO = new FmGrMenuBtnQueryDO();
        fmGrMenuBtnQueryDO.setMenuIds(menuIds);
        List<FmGrMenuBtnDO> fmGrMenuBtnDOS = null;
        try {
            fmGrMenuBtnDOS = fmGrMenuBtnDao.queryList(fmGrMenuBtnQueryDO);
            List<Long> btnIds = fmGrMenuBtnDOS.stream().map(fmGrMenuBtnDO -> fmGrMenuBtnDO.getBtnId()).collect(Collectors.toList());
            FmGrAcbQueryDO fmGrAcbQueryDO = new FmGrAcbQueryDO();
            fmGrAcbQueryDO.setBtnIds(btnIds);
            List<FmGrAcbDO> fmGrAcbDOS = fmGrAcbDao.queryList(fmGrAcbQueryDO);
            List<Long> actionIds = fmGrAcbDOS.stream().map(fmGrAcbDO -> fmGrAcbDO.getActionId()).collect(Collectors.toList());
            FmGrActQueryDO fmGrActQueryDO = new FmGrActQueryDO();
            fmGrActQueryDO.setActionIds(actionIds);
            List<FmGrActDO> fmGrActDOS = fmGrActDao.queryList(fmGrActQueryDO);
            if(!CollectionUtils.isEmpty(fmGrActDOS)){
                fmGrActDOS.forEach(fmGrActDO -> {
                    if(!StringUtils.isEmpty(fmGrActDO.getPath())){
                        permissionList.add(fmGrActDO.getPath());
                    }
                });
            }
        } catch (Exception e) {
            log.error("获取菜单按钮配置异常！");
        }
        fmGrMenuDOS.forEach(fmGrMenuDO -> {
            if(!StringUtils.isEmpty(fmGrMenuDO.getUrl())){
                permissionList.add(fmGrMenuDO.getUrl());
            }
        });

        return permissionList;
    }
}
