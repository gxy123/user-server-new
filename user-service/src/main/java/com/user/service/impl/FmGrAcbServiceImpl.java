package com.user.service.impl;
import com.user.client.domain.FmGrAcbDO;
import com.user.client.query.FmGrAcbQueryDO;
import com.user.dao.FmGrAcbDao;
import com.user.service.FmGrAcbService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class FmGrAcbServiceImpl extends BaseServiceAOImpl<FmGrAcbDO, FmGrAcbQueryDO> implements FmGrAcbService {

    @Resource
    private FmGrAcbDao baseDao;


    @Override
    public BaseDAO<FmGrAcbDO, FmGrAcbQueryDO> getDAO() {
        return baseDao;
    }


}
