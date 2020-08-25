package com.user.client.query;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.user.client.base.BaseQueryDO;

/**
 * 
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrAcbQueryDO extends BaseQueryDO implements Serializable {
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
