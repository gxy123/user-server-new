package com.user.service.impl;
import com.user.client.domain.FmGrActDO;
import com.user.client.domain.FmGrRoleDO;
import com.user.client.query.FmGrActQueryDO;
import com.user.client.query.FmGrRoleQueryDO;
import com.user.client.query.ext.FmGrRoleQueryExt;
import com.user.dao.FmGrActDao;
import com.user.dao.FmGrRoleDao;
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
    public List<FmGrRoleDO> listByUrl(String url) throws Exception {
        FmGrActQueryDO actQueryDO = new FmGrActQueryDO();
        actQueryDO.setPath(url);
        List<FmGrActDO> fmGrActDOS = fmGrActDao.queryList(actQueryDO);
        if(CollectionUtils.isEmpty(fmGrActDOS)){
            return null;
        }
        List<Long> actionIds = fmGrActDOS.stream().map(fmGrActDO -> fmGrActDO.getActionId()).collect(Collectors.toList());

        return null;
    }
}
