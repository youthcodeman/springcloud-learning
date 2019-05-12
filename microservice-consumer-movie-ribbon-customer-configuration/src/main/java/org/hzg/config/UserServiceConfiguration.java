package org.hzg.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hzgal on 2019-5-12.
 * 利用ribbonclient可以对某一个微服务进行个性化配置，本例的效果在于利用本类对microservice-provider-user
 * 这个微服务进行个性化配置
 *
 *
 * 这里需要注意一点的是，配置某个微服务的个性化配置，不应该将其放在application的上下文里面，否则该个性化配置将会被
 * 所有的微服务共享，默认的componentScan是扫描启动类所在的包和其的子包
 */
@Configuration
public class UserServiceConfiguration {

    @Autowired
    private IClientConfig iClientConfig;

    /**
     * 这里可以对该微服务进行一些个性化的配置
     * @param iClientConfig
     * @return
     */
    @Bean
    public IRule ribbonRule(IClientConfig iClientConfig) {
        return new RandomRule();
    }

}
