package com.user.service.impl;
import com.user.client.domain.FmGrRoleDO;
import com.user.client.query.FmGrRoleQueryDO;
import com.user.dao.FmGrRoleDao;
import com.user.service.FmGrRoleService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class FmGrRoleServiceImpl extends BaseServiceAOImpl<FmGrRoleDO, FmGrRoleQueryDO> implements FmGrRoleService {

    @Resource
    private FmGrRoleDao baseDao;


    @Override
    public BaseDAO<FmGrRoleDO, FmGrRoleQueryDO> getDAO() {
        return baseDao;
    }


}
