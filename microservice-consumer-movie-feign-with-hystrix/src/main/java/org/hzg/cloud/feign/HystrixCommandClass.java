package org.hzg.cloud.feign;

import org.hzg.cloud.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created by hzgal on 2019-5-22.
 */
@Component
public class HystrixCommandClass implements  UserFeignClient{
    public User findById(Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }
}
