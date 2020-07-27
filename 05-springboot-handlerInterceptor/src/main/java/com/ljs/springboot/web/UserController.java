package com.ljs.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by ljs on 2020/7/27 16:22
 * description:
 */

@RestController
public class UserController {


    @RequestMapping("/login")
    public String login() {
        return "登录成功";
    }

    @RequestMapping("/user/count")
    public String UserInfo() {
        return "用户信息";
    }

    @RequestMapping("/logout")



}
