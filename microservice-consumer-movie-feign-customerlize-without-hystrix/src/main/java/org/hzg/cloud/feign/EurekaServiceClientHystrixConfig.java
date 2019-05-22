package org.hzg.cloud.feign;

import org.springframework.stereotype.Component;

/**
 * Created by hzgal on 2019-5-22.
 */
@Component
public class EurekaServiceClientHystrixConfig implements EurekaServiceClient {
    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {
        return "如果禁用了，肯定是走不到这里的";
    }


}
