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
import java.util.List;

@Service
@Slf4j
public class FmGrMenuBtnServiceImpl extends BaseServiceAOImpl<FmGrMenuBtnDO, FmGrMenuBtnQueryDO> implements FmGrMenuBtnService {

    @Resource
    private FmGrMenuBtnDao baseDao;


    @Override
    public BaseDAO<FmGrMenuBtnDO, FmGrMenuBtnQueryDO> getDAO() {
        return baseDao;
    }

    @Override
    public List<FmGrMenuBtnDO> getListByMenuIds(List<Long> ids) throws Exception {
        FmGrMenuBtnQueryDO queryDO = new FmGrMenuBtnQueryDO();
        queryDO.setMenuIds(ids);
        List<FmGrMenuBtnDO> fmGrMenuBtnDOS = baseDao.queryList(queryDO);
        return fmGrMenuBtnDOS;
    }
}
