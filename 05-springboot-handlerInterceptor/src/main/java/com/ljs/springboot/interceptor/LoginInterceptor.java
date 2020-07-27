package com.ljs.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * create by ljs on 2020/7/27 16:27
 * description: 定义一个登录拦截器的类
 *
 */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {


        String user = (String) request.getSession().getAttribute("user");
        System.out.println("preHandler " + user);
        if ( user != null ) {
            return true;
        }

        request.getRequestDispatcher("/unauthen").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("这是postHandler； 在controller返回之后，页面渲染之前");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
