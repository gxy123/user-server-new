package com.user.service.impl;
import com.user.client.domain.FmGrActDO;
import com.user.client.query.FmGrActQueryDO;
import com.user.dao.FmGrActDao;
import com.user.service.FmGrActService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class FmGrActServiceImpl extends BaseServiceAOImpl<FmGrActDO, FmGrActQueryDO> implements FmGrActService {

    @Resource
    private FmGrActDao baseDao;


    @Override
    public BaseDAO<FmGrActDO, FmGrActQueryDO> getDAO() {
        return baseDao;
    }


}
