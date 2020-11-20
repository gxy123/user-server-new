package com.user.configer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

/**
 * @author guoxiaoyu
 * @email ggg_xiaoyu@163.com
 * @date 2020/8/27 10:12
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Value("${security.oauth2.resource.id}")
    private String resourceId;
    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret}")
    private String secret;
    @Value("${security.oauth2.authorization.check-token-access}")
    private String checkTokenEndpointUrl;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Resource
    AccessDecisionManager accessDecisionManager;
    @Resource
    FilterInvocationSecurityMetadataSource filterInvocationSecurityMetadataSource;

    @Bean
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setClientId(clientId);
        tokenService.setClientSecret(secret);
        tokenService.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
        return tokenService;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenServices(tokenService()).resourceId(resourceId);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().anyRequest().authenticated().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setAccessDecisionManager(accessDecisionManager);
                o.setSecurityMetadataSource(filterInvocationSecurityMetadataSource);
                return o;
            }
        }).anyRequest().authenticated().and().anonymous().authorities("0000");
        ;
    }
}
