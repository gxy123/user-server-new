package com.user.client.query;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.user.client.base.BaseQueryDO;

/**
 * 菜单表共三级
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrMenuQueryDO extends BaseQueryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Long id;
    @ApiModelProperty("")
    private Long menuId;
    private List<Long> menuIds;
    @ApiModelProperty("")
    private String menuName;
    @ApiModelProperty("")
    private String url;
    @ApiModelProperty("")
    private String icon;
    @ApiModelProperty("")
    private Long parentId;
    @ApiModelProperty("")
    private Integer level;
    @ApiModelProperty("")
    private Date createTime;
    @ApiModelProperty("")
    private Date updateTime;
}
