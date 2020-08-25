package com.user.client.domain;
import com.user.client.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 角色表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrRoleDO extends BaseDO {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty("")
        private Long id;
            @ApiModelProperty("")
        private Long roleId;
            @ApiModelProperty("")
        private String roleName;
            @ApiModelProperty("")
        private String icon;
            @ApiModelProperty("")
        private String des;
            @ApiModelProperty("")
        private Date createTime;
            @ApiModelProperty("")
        private Date updateTime;
    }
