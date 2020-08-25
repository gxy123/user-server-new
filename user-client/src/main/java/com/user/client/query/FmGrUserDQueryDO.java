package com.user.client.query;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.user.client.base.BaseQueryDO;

/**
 * 用户与部门关联表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrUserDQueryDO extends BaseQueryDO implements Serializable {
    private static final long serialVersionUID = 1L;

                    @ApiModelProperty("")
            private Long id;
                    @ApiModelProperty("用户")
            private Long userId;
                    @ApiModelProperty("部门")
            private String deptId;
                    @ApiModelProperty("")
            private Date createTime;
                    @ApiModelProperty("")
            private Date updateTime;
    }
