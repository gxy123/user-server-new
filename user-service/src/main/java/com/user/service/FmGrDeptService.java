package com.user.service;
import com.user.client.domain.FmGrDeptDO;
import com.user.client.query.FmGrDeptQueryDO;
import com.user.service.base.BaseServiceAO;

import java.util.List;

/**
 * 
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
public interface FmGrDeptService extends BaseServiceAO<FmGrDeptDO,FmGrDeptQueryDO> {
    List<FmGrDeptDO> getByUserId(Long userId) throws Exception;
}
