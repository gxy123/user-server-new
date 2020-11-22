package com.user.client.vo;

import com.user.client.base.BaseDO;
import com.user.client.domain.FmGrActDO;
import com.user.client.domain.FmGrMenuBtnDO;
import com.user.client.domain.FmGrMenuDO;
import lombok.Data;

import java.util.List;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020/9/7 14:22
 */
@Data
public class PermissionVo extends BaseDO {
    List<FmGrMenuBtnDO> btnVOList;
    List<FmGrActDO> actDOS;
}
