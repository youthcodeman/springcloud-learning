package org.hzg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConfigClientEurekaApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringCloudConfigClientEurekaApplication.class, args);
  }
}
