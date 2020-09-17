package com.user.service.impl;
import com.user.client.domain.FmGrAcbDO;
import com.user.client.domain.FmGrActDO;
import com.user.client.query.FmGrAcbQueryDO;
import com.user.client.query.FmGrActQueryDO;
import com.user.dao.FmGrAcbDao;
import com.user.dao.FmGrActDao;
import com.user.service.FmGrAcbService;
import com.user.service.FmGrActService;
import com.user.service.base.BaseDAO;
import com.user.service.base.BaseServiceAOImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FmGrActServiceImpl extends BaseServiceAOImpl<FmGrActDO, FmGrActQueryDO> implements FmGrActService {

    @Resource
    private FmGrActDao baseDao;
    @Resource
    private FmGrAcbDao fmGrAcbDao;


    @Override
    public BaseDAO<FmGrActDO, FmGrActQueryDO> getDAO() {
        return baseDao;
    }

    @Override
    public List<FmGrActDO> getListByBtnIds(List<Long> ids) throws Exception {
        FmGrAcbQueryDO acbQueryDO = new FmGrAcbQueryDO();
        acbQueryDO.setBtnIds(ids);
        List<FmGrAcbDO> fmGrAcbDOS = fmGrAcbDao.queryList(acbQueryDO);
        if(CollectionUtils.isEmpty(fmGrAcbDOS)){
            return null;
        }
        List<Long> actionIds = fmGrAcbDOS.stream().map(fmGrAcbDO -> fmGrAcbDO.getActionId()).collect(Collectors.toList());
        FmGrActQueryDO queryDO = new FmGrActQueryDO();
        queryDO.setActionIds(actionIds);
        List<FmGrActDO> fmGrActDOS = baseDao.queryList(queryDO);
        return fmGrActDOS;
    }
}
