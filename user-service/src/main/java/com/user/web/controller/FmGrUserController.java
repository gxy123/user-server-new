package com.user.web.controller;
import com.user.client.domain.FmGrRoleDO;
import com.user.client.vo.FmGrUserVO;
import com.user.service.FmGrRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import   com.user.client.base.CommonResult;
import   com.user.service.FmGrUserService;
import   com.user.service.base.BaseControllerImpl;
import   com.user.service.base.BaseServiceAO;
import   com.user.client.domain.FmGrUserDO;
import   com.user.client.query.FmGrUserQueryDO;

import static com.user.client.base.CommonCode.SYSTEM_ERROR;

/**
 * 用户表
 *
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020-08-25 11:39:42
 */
@RestController
@RequestMapping("/user/auth")
@Slf4j
public class FmGrUserController extends BaseControllerImpl<FmGrUserDO, FmGrUserQueryDO> {

    @Autowired
    private FmGrUserService baseService;
    @Autowired
    private FmGrRoleService fmGrRoleService;

    @Override
    public BaseServiceAO<FmGrUserDO, FmGrUserQueryDO> getService() {
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
    public CommonResult<List<FmGrUserDO>> select(@ModelAttribute("pojo") FmGrUserQueryDO q) {
        CommonResult<List<FmGrUserDO>> query = getService().query(q);
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
    public CommonResult<FmGrUserDO> detail(@RequestParam("id") Long id) {
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
    public CommonResult<Long> update(@ModelAttribute("pojo") FmGrUserDO t) {
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
    public CommonResult<FmGrUserDO> insert(@RequestBody FmGrUserDO t) {
        return getService().save(t);
    }

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    @ApiOperation(value = "根据用户名获取用户信息", httpMethod = "GET", notes = "根据用户名获取用户信息")
    @RequestMapping("byUserName")
    public CommonResult<FmGrUserVO> detail(@RequestParam String  userName) {
        try {
            return baseService.getByUserName(userName);
        } catch (Exception e) {
            log.error("根据用户名获取用户信息异常，msg={}",e.getMessage());
            e.printStackTrace();
        }
        return CommonResult.errorReturn(SYSTEM_ERROR);
    }
    /**
     * 根据url获取包含的角色
     * @param url
     * @return
     */
    @ApiOperation(value = "根据url获取包含的角色", httpMethod = "GET", notes = "根据url获取包含的角色")
    @RequestMapping("getRolesByUrl")
    public CommonResult<List<FmGrRoleDO>> getRolesByUrl(@RequestBody String  url) {
        try {
            return fmGrRoleService.listByUrl(url);
        } catch (Exception e) {
            log.error("根据用户名获取用户信息异常，msg={}",e.getMessage());
            e.printStackTrace();
        }
        return CommonResult.errorReturn(SYSTEM_ERROR);
    }

}
