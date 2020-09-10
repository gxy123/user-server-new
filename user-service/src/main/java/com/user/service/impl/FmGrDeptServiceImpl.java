package com.user.service.impl;
import com.user.client.domain.FmGrDeptDO;
import com.user.client.domain.FmGrUserDDO;
import com.user.client.query.FmGrDeptQueryDO;
import com.user.client.query.FmGrUserDQueryDO;
import com.user.dao.FmGrDeptDao;
import com.user.dao.FmGrUserDDao;
import com.user.service.FmGrDeptService;
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
public class FmGrDeptServiceImpl extends BaseServiceAOImpl<FmGrDeptDO, FmGrDeptQueryDO> implements FmGrDeptService {

    @Resource
    private FmGrDeptDao baseDao;
    @Resource
    private FmGrUserDDao fmGrUserDDao;


    @Override
    public BaseDAO<FmGrDeptDO, FmGrDeptQueryDO> getDAO() {
        return baseDao;
    }

    @Override
    public List<FmGrDeptDO> getByUserId(Long userId) throws Exception {
        FmGrUserDQueryDO queryDO = new FmGrUserDQueryDO();
        queryDO.setUserId(userId);
        List<FmGrUserDDO> fmGrUserDDOS = fmGrUserDDao.queryList(queryDO);
        if(CollectionUtils.isEmpty(fmGrUserDDOS)){
            return null;
        }
        List<String> deptIds = fmGrUserDDOS.stream().map(fmGrUserDDO -> fmGrUserDDO.getDeptId()).collect(Collectors.toList());
        FmGrDeptQueryDO fmGrDeptQueryDO = new FmGrDeptQueryDO();
        fmGrDeptQueryDO.setDeptIds(deptIds);
        List<FmGrDeptDO> fmGrDeptDOS = baseDao.queryList(fmGrDeptQueryDO);
        return fmGrDeptDOS;
    }
}
