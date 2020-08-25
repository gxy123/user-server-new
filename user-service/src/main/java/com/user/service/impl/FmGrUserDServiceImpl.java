package com.user.service.impl;
import com.user.client.domain.FmGrUserDDO;
import com.user.client.query.FmGrUserDQueryDO;
import com.user.dao.FmGrUserDDao;
import com.user.service.FmGrUserDService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class FmGrUserDServiceImpl extends BaseServiceAOImpl<FmGrUserDDO, FmGrUserDQueryDO> implements FmGrUserDService {

    @Resource
    private FmGrUserDDao baseDao;


    @Override
    public BaseDAO<FmGrUserDDO, FmGrUserDQueryDO> getDAO() {
        return baseDao;
    }


}
