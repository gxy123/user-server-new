package com.user.client.query;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.user.client.base.BaseQueryDO;

/**
 * 角色与菜单关联表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrRoleMQueryDO extends BaseQueryDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("")
    private Long id;
    @ApiModelProperty("")
    private Long roleMenuId;
    @ApiModelProperty("")
    private Long roleId;
    @ApiModelProperty("")
    private Long menuId;
    @ApiModelProperty("")
    private Long parentId;
    @ApiModelProperty("")
    private Long btnId;
    private List<Long> menuIds;
}
