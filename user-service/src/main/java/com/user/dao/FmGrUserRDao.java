package com.user.dao;
import com.user.client.domain.FmGrUserRDO;
import com.user.client.query.FmGrUserRQueryDO;
import com.user.service.base.BaseDAO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色关联表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Mapper
public interface FmGrUserRDao extends BaseDAO<FmGrUserRDO, FmGrUserRQueryDO> {

}
