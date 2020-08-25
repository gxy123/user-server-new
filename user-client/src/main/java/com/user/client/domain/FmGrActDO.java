package com.user.client.domain;
import com.user.client.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 接口
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrActDO extends BaseDO {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty("")
        private Long id;
            @ApiModelProperty("")
        private Long actionId;
            @ApiModelProperty("")
        private String path;
            @ApiModelProperty("")
        private Integer isPublic;
            @ApiModelProperty("")
        private String name;
            @ApiModelProperty("")
        private String des;
    }
