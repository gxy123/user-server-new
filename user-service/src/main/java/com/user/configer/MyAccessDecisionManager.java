package com.user.configer;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Objects;
import java.util.regex.Pattern;

import static org.springframework.security.access.AccessDecisionVoter.ACCESS_GRANTED;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020/9/9 17:25
 */
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {

    @Resource
    MyAccessDecisionVoter myAccessDecisionVoter;
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        FilterInvocation fi = (FilterInvocation) o;
        String url = fi.getHttpRequest().getServletPath();
        String reg = "^/api/.*";
        boolean matches = Pattern.matches(reg, url);
        if(matches){
            int vote = myAccessDecisionVoter.vote(authentication, o, collection);
            if(vote!=ACCESS_GRANTED){
                throw new AccessDeniedException("无权限访问！");
            }
        }

    }

    @Override
    public boolean supports(ConfigAttribute configAttribute){return Objects.nonNull(configAttribute.getAttribute());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
