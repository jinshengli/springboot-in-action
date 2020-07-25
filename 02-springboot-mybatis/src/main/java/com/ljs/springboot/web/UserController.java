package com.ljs.springboot.web;

import com.ljs.springboot.mapper.UserMapper;
import com.ljs.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * create by ljs on 2020/7/25 16:46
 * description:
 */

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/list")
    public List<User> getUserList() {

        return userMapper.selectAllUser();
    }

    @RequestMapping("/user")
    public User getUser() {
        return userMapper.selectByPrimaryKey("06f5fc056eac41558a964f96daa7f27c");
    }


}
