package org.hzg.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import org.hzg.cloud.entity.User;
import org.hzg.cloud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.discovery.EurekaClient;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@RestController
public class UserController {

  @Autowired
  private EurekaClient eurekaClient;

  @Autowired
  private DiscoveryClient discoveryClient;

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/simple/{id}")
  public User findById(@PathVariable Long id) {
    return this.userRepository.findOne(id);
  }

  @GetMapping("/eureka-instance")
  public String serviceUrl() {
    InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
    return instance.getHomePageUrl();
  }

  @GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
    return localServiceInstance;
  }
}