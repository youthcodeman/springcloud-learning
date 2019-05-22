package org.hzg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * feign是一个http的客户端，它可以声明式调用其他的微服务，即定义一个接口，利用接口来调用其他微服务
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MovieFeginCustomerlizeWithoutHystrixApplication {

  public static void main(String[] args) {
    SpringApplication.run(MovieFeginCustomerlizeWithoutHystrixApplication.class, args);
  }
}
