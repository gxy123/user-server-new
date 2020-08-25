package com.user.dao;
import com.user.client.domain.FmGrActDO;
import com.user.client.query.FmGrActQueryDO;
import com.user.service.base.BaseDAO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 接口
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Mapper
public interface FmGrActDao extends BaseDAO<FmGrActDO, FmGrActQueryDO> {

}
