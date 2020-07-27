package com.ljs.springboot.config;

import com.ljs.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * create by ljs on 2020/7/27 16:34
 * description:  定义一个配置类； 目的是将拦截器注册到spring容器中。
 *
 *
 *
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  // addPathPatterns("/*") 拦截不了两层的路径。
                .excludePathPatterns("/login")
                .excludePathPatterns("/unauthen");
    }
}
