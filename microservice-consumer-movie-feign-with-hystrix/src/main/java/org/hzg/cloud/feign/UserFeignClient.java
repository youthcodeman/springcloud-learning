package org.hzg.cloud.feign;

import org.hzg.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hzgal on 2019-5-14.
 * 表明该类式一个feign的客户端，其中声明了某个微服务和该微服务的一些方法
 */
@FeignClient(name = "microservice-provider-user",fallback = HystrixCommandClass.class)
public interface UserFeignClient {

    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}
