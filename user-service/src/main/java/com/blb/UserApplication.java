package com.blb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: Mr.Xue
 * @Description:
 * @Date: Created in 12:49 2019/12/26
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.blb.mapper")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
