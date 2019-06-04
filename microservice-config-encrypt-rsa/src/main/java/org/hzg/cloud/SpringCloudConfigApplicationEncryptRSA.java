package org.hzg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigApplicationEncryptRSA {
  public static void main(String[] args) {
    SpringApplication.run(SpringCloudConfigApplicationEncryptRSA.class, args);
  }
}
