package org.hzg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * turbin可以用来监控集群状态下的服务状态
 */

@SpringBootApplication
@EnableTurbine
public class HystrixTurbin3Application {
  public static void main(String[] args) {
    SpringApplication.run(HystrixTurbin3Application.class, args);
  }
}
