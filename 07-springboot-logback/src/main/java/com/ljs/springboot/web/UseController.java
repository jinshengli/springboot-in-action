package com.ljs.springboot.web;

import com.ljs.springboot.mapper.UserMapper;
import com.ljs.springboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by ljs on 2020/7/27 19:56
 * description:
 */

@RestController
@Slf4j
public class UseController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public User getUser() {

        User user = userMapper.selectByPrimaryKey("06f5fc056eac41558a964f96daa7f27c");
        log.info("error" + user);
        log.warn("warn" + user);
        log.info("info" + user);
        log.debug("debug" + user);

        return  user;
    }

}
