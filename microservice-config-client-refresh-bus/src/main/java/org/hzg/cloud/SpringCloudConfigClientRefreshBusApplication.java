package org.hzg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConfigClientRefreshBusApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringCloudConfigClientRefreshBusApplication.class, args);
  }
}
