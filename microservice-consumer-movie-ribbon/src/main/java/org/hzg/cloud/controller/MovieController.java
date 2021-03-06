package org.hzg.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.hzg.cloud.entity.User;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {
  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable Long id) {
    //这里的microservice-provider-user表示的是虚拟ip，即用户微服务注册的spring.application.name
    return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id , User.class);
  }


  /**
   * 注意，利用testTemplate接受list的时候，必须用数组接收，否则报错
   * @return
   */
  @GetMapping("list-all")
  public List<User> listAllUsers() {
    User[] users = this.restTemplate.getForObject("http://microservice-provider-user/list-all" , User[].class);
    List<User> result = Arrays.asList(users);
    return result;
  }
}
