package com.user.client.domain;
import com.user.client.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 菜单表共三级
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrMenuDO extends BaseDO {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty("")
        private Long id;
            @ApiModelProperty("")
        private Long menuId;
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
