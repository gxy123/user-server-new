package com.user.service.impl;
import com.user.client.domain.FmGrMenuBtnDO;
import com.user.client.query.FmGrMenuBtnQueryDO;
import com.user.dao.FmGrMenuBtnDao;
import com.user.service.FmGrMenuBtnService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class FmGrMenuBtnServiceImpl extends BaseServiceAOImpl<FmGrMenuBtnDO, FmGrMenuBtnQueryDO> implements FmGrMenuBtnService {

    @Resource
    private FmGrMenuBtnDao baseDao;


    @Override
    public BaseDAO<FmGrMenuBtnDO, FmGrMenuBtnQueryDO> getDAO() {
        return baseDao;
    }


}
