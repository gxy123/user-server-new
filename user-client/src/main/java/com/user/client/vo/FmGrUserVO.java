package com.user.client.vo;

import com.user.client.domain.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * 授权服务内部使用
 */
@Data
@ApiModel
public class FmGrUserVO extends FmGrUserDO {
    List<FmGrRoleDO> roleDOS;
    List<FmGrMenuDO> menuDOS;
    List<FmGrMenuBtnDO> btnDOS;
    List<FmGrDeptDO>fmGrDeptDOS;
}
