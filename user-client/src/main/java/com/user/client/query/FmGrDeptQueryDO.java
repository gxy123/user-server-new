package com.user.client.query;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.user.client.base.BaseQueryDO;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrDeptQueryDO extends BaseQueryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Long id;
    @ApiModelProperty("")
    private Long deptId;
    List<String> deptIds;
    @ApiModelProperty("")
    private String name;
    @ApiModelProperty("")
    private Long parentId;
    @ApiModelProperty("负责人")
    private Long owner;
    @ApiModelProperty("描述")
    private String des;
}
