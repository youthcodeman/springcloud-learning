package org.hzg.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hzgal on 2019-5-14.
 * 调用eureka的服务，因为eureka已经配置了账号密码，所以就需要配置基本的http的权限
 */
@Configuration
public class ConfigurationEurekaService {
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password123");
    }
}
