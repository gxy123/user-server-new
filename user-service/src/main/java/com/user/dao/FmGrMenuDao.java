package com.user.dao;
import com.user.client.domain.FmGrMenuDO;
import com.user.client.query.FmGrMenuQueryDO;
import com.user.service.base.BaseDAO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单表共三级
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Mapper
public interface FmGrMenuDao extends BaseDAO<FmGrMenuDO, FmGrMenuQueryDO> {

}
