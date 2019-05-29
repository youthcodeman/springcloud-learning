package org.hzg.cloud;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * zuul的filter，主要是在网关处对微服务进行过滤操作，有四种方式
 * pre：可以在请求被路由之前调用
   route：在路由请求时候被调用
   post：在route和error过滤器之后被调用
   error：处理请求时发生错误时被调用

   一个zuul不止代理一个微服务，所以，是不是可以根据微服务来指定相应的过滤器？？？？？？？？？？？？？？？
 */

@Component
public class PreZuulFilter extends ZuulFilter {
  private static final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

  /**
   * 设置这个过滤器是否使用
   * @return
   */
  @Override
  public boolean shouldFilter() {
    return true;
  }

  /**
   * 业务逻辑
   * @return
   */
  @Override
  public Object run() {
    HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
    String host = request.getRemoteHost();
    PreZuulFilter.LOGGER.info("请求的host:{}", host);
    return null;
  }

  /**
   * 定义该过滤器的类型
   * @return
   */
  @Override
  public String filterType() {
    return "pre";
  }

  /**
   * 设置该过滤器的执行先后顺序，数字越大越后执行
   * @return
   */
  @Override
  public int filterOrder() {
    return 1;
  }

}
