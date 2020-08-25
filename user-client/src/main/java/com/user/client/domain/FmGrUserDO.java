package com.user.client.domain;
import com.user.client.base.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 用户表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Data
@ApiModel
public class FmGrUserDO extends BaseDO {

    private static final long serialVersionUID = 1L;

            @ApiModelProperty("")
        private Long id;
            @ApiModelProperty("")
        private Long userId;
            @ApiModelProperty("")
        private String openId;
            @ApiModelProperty("")
        private String realName;
            @ApiModelProperty("")
        private String nickName;
            @ApiModelProperty("")
        private String mobile;
            @ApiModelProperty("")
        private String passWord;
            @ApiModelProperty("")
        private String headerImage;
            @ApiModelProperty("是否是后台用户0:不是，1:是")
        private Integer type;
            @ApiModelProperty("是否注销0：否，1：是")
        private Integer state;
            @ApiModelProperty("")
        private String des;
            @ApiModelProperty("")
        private Date createTime;
            @ApiModelProperty("")
        private Date updateTime;
    }
