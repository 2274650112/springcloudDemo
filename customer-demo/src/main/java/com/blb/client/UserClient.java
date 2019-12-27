package com.blb.client;

import com.blb.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Mr.Xue
 * @Description:
 * @Date: Created in 13:56 2019/12/27
 */
@FeignClient(value = "user-service",fallback =UserFallBack.class)
public interface UserClient {
    @GetMapping("/{id}")
    User querryById(@PathVariable("id") int id);
}
