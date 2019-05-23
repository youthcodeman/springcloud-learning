package org.hzg.cloud.feign;

import feign.hystrix.FallbackFactory;
import org.hzg.cloud.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by hzgal on 2019-5-23.
 */
@Component
public class HystrixFactoryClass implements FallbackFactory<UserFeignClientFactory> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixFactoryClass.class);

    @Override
    public UserFeignClientFactory create(Throwable throwable) {
        LOGGER.info("fallback; reason was: {}", throwable.getMessage());
        return new UserFeignClientFactory() {
            @Override
            public User findById(Long id) {
                User user = new User();
                user.setId(-1L);
                return user;
            }
        };
    }
}
