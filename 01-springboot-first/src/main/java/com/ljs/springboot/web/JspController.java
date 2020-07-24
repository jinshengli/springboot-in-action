package com.ljs.springboot.web;

import com.ljs.springboot.config.SchoolInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * create by ljs on 2020/7/24 17:00
 * description:
 */

@Controller
public class JspController {


    @Autowired
    private SchoolInfo schoolInfo;

    @RequestMapping("/jsp")
    public String getWellcomePage(Model model) {

        System.out.println("index");

        model.addAttribute("school", schoolInfo);

        return "school";
    }


}
