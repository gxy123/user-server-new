package com.user.client.vo;

import com.user.client.domain.FmGrDeptDO;
import com.user.client.domain.FmGrMenuDO;
import com.user.client.domain.FmGrRoleDO;
import com.user.client.domain.FmGrUserDO;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020/8/31 11:16
 */
@Data
public class UserClientVo{
    Set<String> scope;
    FmGrUserDO fmGrUserDO;
    List<FmGrRoleDO> roleDOS;
    List<FmGrMenuVO> menuVOS;
    List<FmGrDeptDO>fmGrDeptDOS;
    List<String> permissionList;
    Object jti;
    Long exp;
    String grant_type;
    Set<String> aud;


}
