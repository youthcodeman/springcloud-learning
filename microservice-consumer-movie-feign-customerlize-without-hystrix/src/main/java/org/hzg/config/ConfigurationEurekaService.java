package org.hzg.config;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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

    /**
     * 这里就是禁用feign下面hystrix配置，因为默认的feignBuilder是移动hystrix的，配置成这个样子就不启动了
     * @return
     */
    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
