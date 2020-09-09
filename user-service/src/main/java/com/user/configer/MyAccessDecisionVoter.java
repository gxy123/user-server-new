package com.user.configer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020/9/9 13:37
 */
@Slf4j
@Component
public class MyAccessDecisionVoter implements AccessDecisionVoter<Object> {
    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return Objects.nonNull(configAttribute.getAttribute());
    }

    @Override
    public int vote(Authentication authentication, Object o, Collection<ConfigAttribute> attributes) {
        FilterInvocation fi = (FilterInvocation) o;
        String url = fi.getRequestUrl();
        log.info("进入权限校验...url={}",url);
        if (CollectionUtils.isEmpty(attributes)) {
            log.warn("权限校验拒绝！ACCESS_DENIED");
            return ACCESS_DENIED;
        }
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<ConfigAttribute> configAttributeList = (List<ConfigAttribute>) attributes;
        AtomicBoolean disjoint = new AtomicBoolean(false);
        authorities.forEach(grantedAuthority -> {
            log.info("用户持有权限：{}",grantedAuthority.getAuthority());
            configAttributeList.forEach(configAttribute -> {
                log.info("资源所需权限：{}",configAttribute.getAttribute());
                if(grantedAuthority.getAuthority().equals(configAttribute.getAttribute())){
                    disjoint.set(true);
                    return;
                }
            });
        });
        if(disjoint.get()){
            log.info("权限校验通过！ACCESS_GRANTED");
            return ACCESS_GRANTED;
        }
        log.warn("权限校验拒绝！ACCESS_DENIED");
        return ACCESS_DENIED;
    }

    @Override
    public boolean supports(Class aClass) {
        return true;
    }
}
