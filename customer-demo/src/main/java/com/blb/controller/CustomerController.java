package com.blb.controller;

import com.blb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: Mr.Xue
 * @Description:
 * @Date: Created in 13:15 2019/12/26
 */
@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    /*@GetMapping("/{id}")
    public User getUser(@PathVariable("id") int i ){
        return restTemplate.getForObject("http://localhost:8089/user/"+i,User.class);

    }*/

    /*@GetMapping("/{id}")
    public User getUser(@PathVariable("id") int i ){
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance = instances.get(0);
        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+i;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }*/

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int i ){

        String url="http://user-service/user/"+i;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }
}
