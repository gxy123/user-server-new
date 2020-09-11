package com.user.client.vo;

import com.user.client.domain.FmGrDeptDO;
import com.user.client.domain.FmGrRoleDO;
import com.user.client.domain.FmGrUserDO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class FmGrUserVO extends FmGrUserDO {
    List<FmGrRoleDO> roleDOS;
    List<FmGrMenuVO> menuVOS;
    List<FmGrDeptDO>fmGrDeptDOS;
    List<String> permissionList;
}
