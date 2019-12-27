package com.blb.controller;

import com.blb.client.UserClient;
import com.blb.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
//@DefaultProperties(defaultFallback = "defaultFallback")
public class CustomerController {
//    @Autowired
//    private RestTemplate restTemplate;

   // @Autowired
    //private DiscoveryClient discoveryClient;
    @Autowired
    private UserClient userClient;
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

//    @GetMapping("/{id}")
//    public User getUser(@PathVariable("id") int i ){
//
//        String url="http://user-service/user/"+i;
//        User user = restTemplate.getForObject(url, User.class);
//        return user;
//    }

    //Hystrix第一种使用方式
//    @GetMapping("/{id}")
//    @HystrixCommand(fallbackMethod = "queryBack")
//    public String getUser(@PathVariable("id") int i ){
//
//        String url="http://user-service/user/"+i;
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }
//    //发生失败调用方法
//    public String queryBack(int i){
//        return "抱歉网络拥堵";
//    }

//    //Hystrix第二种使用方式
//    @GetMapping("/{id}")
//    @HystrixCommand//方法使用熔断器
//    public String getUser(@PathVariable("id") int i ){
//
//        String url="http://user-service/user/"+i;
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }
//    //发生失败调用defaultFallback()
//    public String defaultFallback(){
//        return "抱歉网络拥堵";
//    }

    @GetMapping("/{id}")
    //@HystrixCommand//方法使用熔断器
    public User getUser(@PathVariable("id") int i ){

        return userClient.querryById(i);
    }
}
