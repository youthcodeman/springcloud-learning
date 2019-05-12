package org.hzg.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.hzg.cloud.entity.User;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private LoadBalancerClient loadBalancerClient;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    //这里的microservice-provider-user表示的是虚拟ip，即用户微服务注册的spring.application.name
    return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id , User.class);
  }

  @GetMapping("/movie/customeredRibbonCilent/{id}")
  public User findByCustomerdConfigRibbonClient(@PathVariable Long id) {
    ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
    System.out.println("微服务端口：" + serviceInstance.getPort() + "========================");
    return this.restTemplate.getForObject("http://"+ serviceInstance.getServiceId() + "/simple/" + id , User.class);
  }
}
