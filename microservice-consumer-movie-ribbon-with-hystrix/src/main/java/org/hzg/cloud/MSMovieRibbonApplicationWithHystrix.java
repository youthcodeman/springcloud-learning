package org.hzg.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class MSMovieRibbonApplicationWithHystrix {

  /**
   * 利用restTemplate来调用微服务，利用ribbon来进行客户端的负载
   *
   * ribbon的原理：在微服务引入了ribbon的时候，微服务中的ribbon会到该微服务所配置的注册中心去拉取已经
   * 注册的微服务（这里用的eureka），然后把拉取的已经注册的微服务的利用算法进行负载（默认轮询）。当微服务
   * 需要利用注册的id去调用其他的微服务的时候，由ribbon去指到需要调用的微服务。
   *
   * ribbon使用方法，只需要添加@LoadBalanced注解即可。
   * @return
   */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(MSMovieRibbonApplicationWithHystrix.class, args);
  }
}
