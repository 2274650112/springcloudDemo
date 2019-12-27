package com.blb.client;

import com.blb.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @Author: Mr.Xue
 * @Description:
 * @Date: Created in 14:07 2019/12/27
 */
@Component
public class UserFallBack implements UserClient {


    @Override
    public User querryById(int id) {
        User user=new User();
        user.setName("又拥堵了");
        return user;
    }
}
