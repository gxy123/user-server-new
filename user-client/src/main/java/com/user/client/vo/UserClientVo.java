package com.user.client.vo;

import com.user.client.domain.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020/8/31 11:16
 * 客户端使用
 */
@Data
public class UserClientVo{
    Set<String> scope;
    FmGrUserDO fmGrUserDO;
    List<FmGrRoleDO> roleDOS;
    List<FmGrMenuDO> menuDOS;
    List<FmGrMenuBtnDO> btnDOS;
    List<FmGrDeptDO>fmGrDeptDOS;
    //List<String> permissionList;
    Long userId;


}
