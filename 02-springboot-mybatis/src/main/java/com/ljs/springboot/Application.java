package com.ljs.springboot;


import com.ljs.springboot.mapper.UserMapper;
import com.ljs.springboot.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;


@SpringBootApplication
@MapperScan("com.ljs.springboot.mapper")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(Application.class, args);

        UserMapper userMapper = context.getBean(UserMapper.class);
        List<User> users =
                userMapper.selectAllUser();

        for (User user : users) {
            System.out.println(user);
        }
    }

}
