package com.user.service;
import com.user.client.domain.FmGrRoleDO;
import com.user.client.query.FmGrRoleQueryDO;
import com.user.service.base.BaseServiceAO;

import java.util.List;

/**
 * 角色表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
public interface FmGrRoleService extends BaseServiceAO<FmGrRoleDO,FmGrRoleQueryDO> {

    List<FmGrRoleDO>listByRoleIds(List<Long> roleIds) throws Exception;

}
