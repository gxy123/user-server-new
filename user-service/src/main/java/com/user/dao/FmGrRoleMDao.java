package com.user.dao;
import com.user.client.domain.FmGrRoleMDO;
import com.user.client.query.FmGrRoleMQueryDO;
import com.user.service.base.BaseDAO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与菜单关联表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Mapper
public interface FmGrRoleMDao extends BaseDAO<FmGrRoleMDO, FmGrRoleMQueryDO> {

}
