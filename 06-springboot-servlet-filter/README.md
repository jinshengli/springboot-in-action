

#### springboot 中使用 servlet, filter


####  使用servlet有两种方式；filter也类似

##### 一： 使用@WebServlet(urlPatterns = "/servlet") 和@ServletComponentScan(basePackages = "com.ljs.springboot.servlet")


    @WebServlet注解和@ServletComponent结合使用


##### 二： 定义普通Servlet类；通过ServletRegistrationBean注册servlet
    
    @Bean
    public ServletRegistrationBean<javax.servlet.http.HttpServlet> myServletRegistration() {
    
        ServletRegistrationBean servletRegistrationBean =
                new ServletRegistrationBean<>(new MyServlet(),
                        "/servlet1");
        return servletRegistrationBean;
    
    }


