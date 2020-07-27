package com.ljs.springboot.config;

import com.ljs.springboot.filter.MyFilter;
import com.ljs.springboot.servlet.MyServlet;
import com.ljs.springboot.servlet.SecondServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * create by ljs on 2020/7/27 17:22
 * description:  servlet的配置类；
 */

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<javax.servlet.http.HttpServlet> myServletRegistration() {

        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean<>(new MyServlet(),
                        "/servlet1");
        return servletRegistrationBean;

    }

    @Bean
    public ServletRegistrationBean<javax.servlet.Servlet> secondServletRegistration() {

         ServletRegistrationBean registrationBean = new ServletRegistrationBean<>(new SecondServlet(),
                "/servlet2");
         return registrationBean;
    }


    @Bean
    public FilterRegistrationBean MyFilter() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new MyFilter());
        filterRegistrationBean.addUrlPatterns("/filter1");
        return filterRegistrationBean;

    }


    @Bean
    public FilterRegistrationBean charaEncodingFilter() {

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

        //强制使用指定字符编码
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("utf-8");

        FilterRegistrationBean filterRegistrationBean = new
                FilterRegistrationBean(characterEncodingFilter);

        filterRegistrationBean.addUrlPatterns("/**");

        return filterRegistrationBean;

    }


}
