package com.user.dao;
import com.user.client.domain.FmGrDeptDO;
import com.user.client.query.FmGrDeptQueryDO;
import com.user.service.base.BaseDAO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Mapper
public interface FmGrDeptDao extends BaseDAO<FmGrDeptDO, FmGrDeptQueryDO> {

}
