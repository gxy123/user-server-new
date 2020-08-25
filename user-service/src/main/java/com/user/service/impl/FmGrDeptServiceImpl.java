package com.user.service.impl;
import com.user.client.domain.FmGrDeptDO;
import com.user.client.query.FmGrDeptQueryDO;
import com.user.dao.FmGrDeptDao;
import com.user.service.FmGrDeptService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class FmGrDeptServiceImpl extends BaseServiceAOImpl<FmGrDeptDO, FmGrDeptQueryDO> implements FmGrDeptService {

    @Resource
    private FmGrDeptDao baseDao;


    @Override
    public BaseDAO<FmGrDeptDO, FmGrDeptQueryDO> getDAO() {
        return baseDao;
    }


}
