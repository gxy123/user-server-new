package com.user.service;
import com.user.client.domain.FmGrMenuDO;
import com.user.client.query.FmGrMenuQueryDO;
import com.user.client.vo.PermissionVo;
import com.user.service.base.BaseServiceAO;

import java.util.List;

/**
 * 菜单表共三级
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
public interface FmGrMenuService extends BaseServiceAO<FmGrMenuDO,FmGrMenuQueryDO> {

    List<FmGrMenuDO>getByRoleIds(List<Long>roleIds) throws Exception;
    List<FmGrMenuDO>getDOByRoleIds(List<Long>roleIds) throws Exception;
    PermissionVo getPermissionByRoleIds(List<Long>roleIds) throws Exception;

}
