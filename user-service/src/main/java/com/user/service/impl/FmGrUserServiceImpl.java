package com.user.service.impl;
import com.user.client.domain.FmGrUserDO;
import com.user.client.query.FmGrUserQueryDO;
import com.user.dao.FmGrUserDao;
import com.user.service.FmGrUserService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class FmGrUserServiceImpl extends BaseServiceAOImpl<FmGrUserDO, FmGrUserQueryDO> implements FmGrUserService {

    @Resource
    private FmGrUserDao baseDao;


    @Override
    public BaseDAO<FmGrUserDO, FmGrUserQueryDO> getDAO() {
        return baseDao;
    }


}
