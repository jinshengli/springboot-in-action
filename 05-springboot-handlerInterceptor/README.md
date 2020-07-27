
##### springboot中使用拦截器


1） 定义一个拦截器类，实现HandlerInterceptor接口

    根据情况重写接口的三个方法。
    preHandle
        请求在进入controller之前出来的方法。
    postHandle
        请求在处理完controller之后，在返回页面之前、
    afterCompletion
        返回页面之后处理。
        
2） 通过WebMvcConfigurer的配置类，将通过注册器注册过滤器到spring容器中。

    实现WebMvcConfigurer接口，重写addInterceptors方法；
    
    将注册过滤器，定义过滤的请求范围，不要求过滤的范围。        