package org.hzg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy  //因为zuul不包含任何的服务发现客户端，所以它需要依赖服务发现的组件来使用，@EnableZuulProxy是一个组合注解
public class ZuulFileUploadApplication {
  public static void main(String[] args) {
    SpringApplication.run(ZuulFileUploadApplication.class, args);
  }
}
