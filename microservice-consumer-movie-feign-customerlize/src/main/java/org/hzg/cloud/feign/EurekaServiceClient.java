package org.hzg.cloud.feign;

import org.hzg.config.ConfigurationEurekaService;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hzgal on 2019-5-14.
 */
@FeignClient(name="xxx", url = "http://localhost:8761/", configuration = ConfigurationEurekaService.class)
public interface EurekaServiceClient {
    @RequestMapping(value = "/eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
