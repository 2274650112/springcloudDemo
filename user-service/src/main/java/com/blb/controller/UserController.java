package com.blb.controller;

import com.blb.pojo.User;
import com.blb.service.UserSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Mr.Xue
 * @Description:
 * @Date: Created in 12:59 2019/12/26
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserSercice userSercice;
    @GetMapping("/{id}")
    public User querryById(@PathVariable("id") int id){
        return userSercice.querryById(id);
    }
}
