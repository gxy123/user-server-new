package com.user.client.domain;
import com.user.client.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 角色与菜单关联表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrRoleMDO extends BaseDO {

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
    }
