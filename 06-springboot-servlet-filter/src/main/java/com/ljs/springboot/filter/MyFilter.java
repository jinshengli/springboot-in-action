package com.ljs.springboot.filter;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;


import java.io.IOException;

/**
 * create by ljs on 2020/7/27 19:11
 * description:
 */

//@WebFilter(urlPatterns = "/filter1")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("通过了Fileter");
        servletResponse.getWriter().print("这是个Filter");
        servletResponse.getWriter().flush();
        servletResponse.getWriter().close();
    }

    @Override
    public void destroy() {

    }
}
