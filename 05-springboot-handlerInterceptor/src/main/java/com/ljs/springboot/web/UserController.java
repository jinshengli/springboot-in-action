package com.ljs.springboot.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * create by ljs on 2020/7/27 16:22
 * description:
 */

@RestController
public class UserController {


    @RequestMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("user", "yes");
        return "登录成功";
    }

    @RequestMapping("/user/count")
    public String UserInfo() {
        return "用户信息";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "退出登录成功";
    }

    @RequestMapping("/unauthen")
    public String unauthen() {
        return "还未登录";
    }



}
