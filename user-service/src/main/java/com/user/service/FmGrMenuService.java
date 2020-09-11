package com.user.service;
import com.user.client.domain.FmGrMenuDO;
import com.user.client.query.FmGrMenuQueryDO;
import com.user.client.vo.FmGrMenuVO;
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

    List<FmGrMenuVO>getByRoleIds(List<Long>roleIds) throws Exception;
    List<String>getPermissionByRoleIds(List<Long>roleIds) throws Exception;

}
