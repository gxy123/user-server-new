package com.user.service;
import com.user.client.domain.FmGrMenuBtnDO;
import com.user.client.query.FmGrMenuBtnQueryDO;
import com.user.service.base.BaseServiceAO;

import java.util.List;

/**
 * 
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
public interface FmGrMenuBtnService extends BaseServiceAO<FmGrMenuBtnDO,FmGrMenuBtnQueryDO> {
    List<FmGrMenuBtnDO>getListByMenuIds(List<Long> ids) throws Exception;
}
