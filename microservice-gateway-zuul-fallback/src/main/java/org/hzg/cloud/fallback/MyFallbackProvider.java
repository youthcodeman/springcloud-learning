package org.hzg.cloud.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * zuul的fallback和@hystrixCommand还有feign的fallback的细粒度不同
 * zuu的fallback是以微服务为维度的，它可以定义该微服务在断路器打开的时候的请求的header、http状态码等信息
 * hystrixCommand 可以自定义某个方法在断路器打开时进行相应的操作
 * feign 是一个声明式微服务调用框架，它可以自定义属性，可以是一个fallback的类，里面实现了feign接口的调用方法，可以指定服务中的哪些方法进行
 * 断路器打开时的操作，相对比较灵活
 */

@Component
public class MyFallbackProvider implements ZuulFallbackProvider {
  @Override
  public String getRoute() {
    return "microservice-provider-user";
  }

  @Override
  public ClientHttpResponse fallbackResponse() {
    return new ClientHttpResponse() {
      @Override
      public HttpStatus getStatusCode() throws IOException {
        return HttpStatus.BAD_REQUEST;
      }

      @Override
      public int getRawStatusCode() throws IOException {
        return HttpStatus.BAD_REQUEST.value();
      }

      @Override
      public String getStatusText() throws IOException {
        return HttpStatus.BAD_REQUEST.getReasonPhrase();
      }

      @Override
      public void close() {
      }

      @Override
      public InputStream getBody() throws IOException {
        return new ByteArrayInputStream(("fallback" + MyFallbackProvider.this.getRoute()).getBytes());
      }

      @Override
      public HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
      }
    };
  }
}