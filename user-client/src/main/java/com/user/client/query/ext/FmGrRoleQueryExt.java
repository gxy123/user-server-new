package com.user.client.query.ext;

import com.user.client.query.FmGrRoleQueryDO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class FmGrRoleQueryExt extends FmGrRoleQueryDO {
    List<Long> roleIds;
}
