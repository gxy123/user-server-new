package com.user.web.api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import   com.user.client.base.CommonResult;
import   com.user.service.FmGrDeptService;
import   com.user.service.base.BaseControllerImpl;
import   com.user.service.base.BaseServiceAO;
import   com.user.client.domain.FmGrDeptDO;
import   com.user.client.query.FmGrDeptQueryDO;

/**
 * 
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@Api(description = "-相关接口")
@Slf4j
@RestController
@RequestMapping("/api/fmgrdept")
public class FmGrDeptApi extends BaseControllerImpl<FmGrDeptDO, FmGrDeptQueryDO> {

    @Autowired
    private FmGrDeptService baseService;

    @Override
    public BaseServiceAO<FmGrDeptDO, FmGrDeptQueryDO> getService() {
        return baseService;
    }
    /**
     * 通用查询逻辑
     *
     * @param q        查询对象
     * @return
     */
    @ApiOperation(value = "通用查询逻辑", httpMethod = "GET", notes = "通用查询逻辑")
    @RequestMapping("query")
    public CommonResult<List<FmGrDeptDO>> select(@ModelAttribute("pojo") FmGrDeptQueryDO q) {
        CommonResult<List<FmGrDeptDO>> query = getService().query(q);
        CommonResult<Integer> count = getService().count(q);
        query.setTotal(count.getResult());
        return query;
    }

    /**
     * 获取详情
     *
     * @return
     */
    @ApiOperation(value = "获取详情", httpMethod = "GET", notes = "获取详情")
    @RequestMapping("get")
    public CommonResult<FmGrDeptDO> detail(@RequestParam("id") Long id) {
        return getService().get(id);
    }

    /**
     * 通用更新逻辑
     *
     * @param t
     * @return
     */
    @ApiOperation(value = "通用更新逻辑", httpMethod = "GET", notes = "通用更新逻辑")
    @RequestMapping("update")
    public CommonResult<Long> update(@ModelAttribute("pojo") FmGrDeptDO t) {
        return getService().modify(t);
    }

    /**
     * 通用删除逻辑
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "通用删除逻辑", httpMethod = "GET", notes = "通用删除逻辑")
    @RequestMapping("delete")
    public CommonResult<Long> delete(@RequestParam("id") Long id) {
        return getService().remove(id);
    }

    /**
     * 通用插入逻辑
     *
     * @param t
     * @return
     */
    @ApiOperation(value = "通用插入逻辑", httpMethod = "POST", notes = "通用插入逻辑")
    @RequestMapping("add")
    public CommonResult<FmGrDeptDO> insert(@RequestBody FmGrDeptDO t) {
        return getService().save(t);
    }
}
