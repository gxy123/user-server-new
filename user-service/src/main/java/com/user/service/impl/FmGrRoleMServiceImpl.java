package com.user.service.impl;
import com.user.client.domain.FmGrRoleMDO;
import com.user.client.query.FmGrRoleMQueryDO;
import com.user.dao.FmGrRoleMDao;
import com.user.service.FmGrRoleMService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class FmGrRoleMServiceImpl extends BaseServiceAOImpl<FmGrRoleMDO, FmGrRoleMQueryDO> implements FmGrRoleMService {

    @Resource
    private FmGrRoleMDao baseDao;


    @Override
    public BaseDAO<FmGrRoleMDO, FmGrRoleMQueryDO> getDAO() {
        return baseDao;
    }


}
