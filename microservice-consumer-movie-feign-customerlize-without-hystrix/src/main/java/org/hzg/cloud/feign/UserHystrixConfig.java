package org.hzg.cloud.feign;

import org.hzg.cloud.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by hzgal on 2019-5-22.
 */
@Component
public class UserHystrixConfig implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User defaultUser = new User();
        defaultUser.setId(0L);
        return defaultUser;
    }
}
