package org.hzg.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.hzg.cloud.entity.User;

import java.util.Arrays;
import java.util.List;

/**
 * hystrix 就是设置一个熔断器，在服务不能正常提供服务的时候提供一种熔断的机制，或者超时机制。其实其就是利用了反射和代理的方式，
 * 将服务中的方法代理起来，或是进行超时调用判断，或是异常重新执行到指定的方法。
 * 注意，回退方法必须和请求方法的参数和返回值一致
 */
@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/movie/{id}")
  @HystrixCommand(fallbackMethod = "findByIdFallback")
  public User findById(@PathVariable Long id) {
    //这里的microservice-provider-user表示的是虚拟ip，即用户微服务注册的spring.application.name
    return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id , User.class);
  }

  public User findByIdFallback(Long id) {
    User user = new User();
    user.setId(0L);
    return user;
  }

}
