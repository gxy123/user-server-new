package com.user.service;
import com.user.client.base.CommonResult;
import com.user.client.domain.FmGrUserDO;
import com.user.client.query.FmGrUserQueryDO;
import com.user.client.vo.FmGrUserVO;
import com.user.service.base.BaseServiceAO;

/**
 * 用户表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
public interface FmGrUserService extends BaseServiceAO<FmGrUserDO,FmGrUserQueryDO> {
    CommonResult<FmGrUserVO> getByUserName(String userName) throws Exception;

}
