package com.ljs.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication

// @ServletComponentScan(basePackages = "com.ljs.springboot.servlet")
// @ServletComponentScan(basePackages = "com.ljs.springboot.filter")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
