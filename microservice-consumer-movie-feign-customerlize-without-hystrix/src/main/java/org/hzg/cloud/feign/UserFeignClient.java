package org.hzg.cloud.feign;

import feign.Param;
import feign.RequestLine;
import org.hzg.cloud.entity.User;
import org.hzg.config.ConfigurationUserMService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hzgal on 2019-5-14.
 * 表明该类式一个feign的客户端，其中声明了某个微服务和该微服务的一些方法
 * 自定义配置，ConfigurationUserMService类中定义了feign的configuration 使用了feign的默认契约，因此在声明接口的时候，就需要
 * 利用feign的默认注解
 */
@FeignClient(name="microservice-provider-user", configuration = ConfigurationUserMService.class, fallback = UserHystrixConfig.class)
public interface UserFeignClient {

    @RequestLine("GET /simple/{id}")
    public User findById(@Param("id") Long id);
}
