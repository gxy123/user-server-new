package com.user.dao;
import com.user.client.domain.FmGrRoleDO;
import com.user.client.query.FmGrRoleQueryDO;
import com.user.service.base.BaseDAO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Mapper
public interface FmGrRoleDao extends BaseDAO<FmGrRoleDO, FmGrRoleQueryDO> {

}
