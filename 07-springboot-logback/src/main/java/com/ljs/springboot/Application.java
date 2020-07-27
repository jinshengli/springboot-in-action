package com.ljs.springboot;

import com.ljs.springboot.mapper.UserMapper;
import com.ljs.springboot.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ljs.springboot.mapper")
public class Application implements CommandLineRunner {


    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = userMapper.selectByPrimaryKey("06f5fc056eac41558a964f96daa7f27c");
        System.out.println(user);

    }
}
