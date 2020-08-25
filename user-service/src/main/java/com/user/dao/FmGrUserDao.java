package com.user.dao;
import com.user.client.domain.FmGrUserDO;
import com.user.client.query.FmGrUserQueryDO;
import com.user.service.base.BaseDAO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Mapper
public interface FmGrUserDao extends BaseDAO<FmGrUserDO, FmGrUserQueryDO> {

}
