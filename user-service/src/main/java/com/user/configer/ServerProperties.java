package com.user.configer;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author:  guoxiaoyu
 * @date : 2018/4/25
 */
@Data
@Component
@ConfigurationProperties(
        prefix = "service.config"
)
public class ServerProperties {
}
