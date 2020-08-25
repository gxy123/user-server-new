package com.user.web.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import   com.user.client.base.CommonResult;
import   com.user.service.FmGrUserRService;
import   com.user.service.base.BaseControllerImpl;
import   com.user.service.base.BaseServiceAO;
import   com.user.client.domain.FmGrUserRDO;
import   com.user.client.query.FmGrUserRQueryDO;

/**
 * 用户与角色关联表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@RestController
@RequestMapping("/user/fmgruserr")
@Slf4j
public class FmGrUserRController extends BaseControllerImpl<FmGrUserRDO, FmGrUserRQueryDO> {

    @Autowired
    private FmGrUserRService baseService;

    @Override
    public BaseServiceAO<FmGrUserRDO, FmGrUserRQueryDO> getService() {
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
    public CommonResult<List<FmGrUserRDO>> select(@ModelAttribute("pojo") FmGrUserRQueryDO q) {
        CommonResult<List<FmGrUserRDO>> query = getService().query(q);
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
    public CommonResult<FmGrUserRDO> detail(@RequestParam("id") Long id) {
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
    public CommonResult<Long> update(@ModelAttribute("pojo") FmGrUserRDO t) {
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
    public CommonResult<FmGrUserRDO> insert(@RequestBody FmGrUserRDO t) {
        return getService().save(t);
    }
}
