package com.user.service.impl;
import com.user.client.domain.FmGrMenuDO;
import com.user.client.query.FmGrMenuQueryDO;
import com.user.dao.FmGrMenuDao;
import com.user.service.FmGrMenuService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class FmGrMenuServiceImpl extends BaseServiceAOImpl<FmGrMenuDO, FmGrMenuQueryDO> implements FmGrMenuService {

    @Resource
    private FmGrMenuDao baseDao;


    @Override
    public BaseDAO<FmGrMenuDO, FmGrMenuQueryDO> getDAO() {
        return baseDao;
    }


}
