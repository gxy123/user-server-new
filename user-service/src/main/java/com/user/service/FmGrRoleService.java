package com.user.service;
import com.user.client.base.CommonResult;
import com.user.client.domain.FmGrRoleDO;
import com.user.client.query.FmGrRoleQueryDO;
import com.user.service.base.BaseServiceAO;

import java.util.List;
import java.util.Map;

/**
 * 角色表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
public interface FmGrRoleService extends BaseServiceAO<FmGrRoleDO,FmGrRoleQueryDO> {

    List<FmGrRoleDO>listByRoleIds(List<Long> roleIds) throws Exception;
    CommonResult<List<FmGrRoleDO>> listByUrl(String url) throws Exception;
    List<FmGrRoleDO> listByUserId(Long userId) throws Exception;
   Map<Long,List<String>> allPath() throws Exception;

}
