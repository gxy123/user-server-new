package com.user.client.domain;
import com.user.client.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrAcbDO extends BaseDO {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty("")
        private Long id;
            @ApiModelProperty("")
        private Long actionMapId;
            @ApiModelProperty("")
        private Long actionId;
            @ApiModelProperty("")
        private Long btnId;
            @ApiModelProperty("")
        private Long menuId;
    }
