package com.user.client.vo;

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
public class FmGrMenuVO extends FmGrMenuDO {
    List<FmGrMenuBtnDO> btnVOList;
}
