package com.blb.service;

import com.blb.mapper.UserMapper;
import com.blb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Mr.Xue
 * @Description:
 * @Date: Created in 12:58 2019/12/26
 */
@Service
public class UserSercice {
    @Autowired
    private UserMapper userMapper;

    public User querryById(int id){
        return userMapper.selectByPrimaryKey(id);
    }
}
