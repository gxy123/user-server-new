package com.user.service.impl;
import com.user.client.domain.FmGrRoleDO;
import com.user.client.query.FmGrRoleQueryDO;
import com.user.client.query.ext.FmGrRoleQueryExt;
import com.user.dao.FmGrRoleDao;
import com.user.service.FmGrRoleService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class FmGrRoleServiceImpl extends BaseServiceAOImpl<FmGrRoleDO, FmGrRoleQueryDO> implements FmGrRoleService {

    @Resource
    private FmGrRoleDao baseDao;


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
}
