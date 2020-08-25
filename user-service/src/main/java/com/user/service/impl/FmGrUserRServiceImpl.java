package com.user.service.impl;
import com.user.client.domain.FmGrUserRDO;
import com.user.client.query.FmGrUserRQueryDO;
import com.user.dao.FmGrUserRDao;
import com.user.service.FmGrUserRService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class FmGrUserRServiceImpl extends BaseServiceAOImpl<FmGrUserRDO, FmGrUserRQueryDO> implements FmGrUserRService {

    @Resource
    private FmGrUserRDao baseDao;


    @Override
    public BaseDAO<FmGrUserRDO, FmGrUserRQueryDO> getDAO() {
        return baseDao;
    }


}
