package com.ljs.springboot.web;

import com.ljs.springboot.config.SchoolInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * create by ljs on 2020/7/24 15:11
 * description:
 */

@RestController
public class UserController {

    @Value("${school.name}")
    private String schoolName;

    @Value("${school.address}")
    private String schoolAddress;

    @Value("${city}")
    private String city;

    @Autowired
    private SchoolInfo schoolInfo;

    @RequestMapping("/index")
    public Map<String, Object> index() {

        Map<String,Object> map = new HashMap<>();
        map.put("schoolName", schoolName);
        map.put("schoolAddress", schoolAddress);
        map.put("city", city);

        System.out.println(map);
        return map;
    }

    @RequestMapping("/schoolInfo")
    public SchoolInfo schoolInfo() {
        System.out.println(schoolInfo);
        return schoolInfo;
    }




}
