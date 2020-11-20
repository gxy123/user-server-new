package com.user.configer;

import com.user.client.base.CommonResult;
import com.user.client.domain.FmGrRoleDO;
import com.user.service.FmGrRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020/9/7 13:51
 */
@Slf4j
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Resource
    FmGrRoleService fmGrRoleService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //根据url返回所有包含次权限的角色

        FilterInvocation fi = (FilterInvocation) o;
        String url = fi.getHttpRequest().getServletPath();
        String reg = "^/api/.*";
        boolean matches = Pattern.matches(reg, url);
        if (!matches) {
            log.info("内部请求放行...url={}", url);
            return null;
        }
        log.info("校验url={}", url);
        List<ConfigAttribute> list = new ArrayList<>();
        try {
            CommonResult<List<FmGrRoleDO>> listCommonResult = fmGrRoleService.listByUrl(url);
            List<FmGrRoleDO> fmGrRoleDOS = listCommonResult.getResult();
            if (CollectionUtils.isEmpty(fmGrRoleDOS)) {
                log.error("未匹配到角色！url={}", url);
                return list;
            }
            fmGrRoleDOS.forEach(fmGrRoleDO -> {
                list.add(new ConfigAttribute() {
                    @Override
                    public String getAttribute() {
                        return fmGrRoleDO.getRoleId().toString();
                    }
                });
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        //返回所有角色
        System.out.println("w23r23r23r");
        return null;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
