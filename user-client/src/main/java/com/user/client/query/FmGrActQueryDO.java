package com.user.client.query;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.user.client.base.BaseQueryDO;

/**
 * 接口
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrActQueryDO extends BaseQueryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Long id;
    @ApiModelProperty("")
    private Long actionId;
    private List<Long> actionIds;
    @ApiModelProperty("")
    private String path;
    @ApiModelProperty("")
    private Integer isPublic;
    @ApiModelProperty("")
    private String name;
    @ApiModelProperty("")
    private String des;
}
