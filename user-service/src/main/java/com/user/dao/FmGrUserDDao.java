package com.user.dao;
import com.user.client.domain.FmGrUserDDO;
import com.user.client.query.FmGrUserDQueryDO;
import com.user.service.base.BaseDAO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与部门关联表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Mapper
public interface FmGrUserDDao extends BaseDAO<FmGrUserDDO, FmGrUserDQueryDO> {

}
