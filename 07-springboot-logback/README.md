
###### 配置logback日志 


    日志命名：xxx-spring.xml
    
    springboot 指定配置文件： logging.config=classpath:logback-spring.xml

    <!--输出sql日志-->
    <logger name="com.ljs.springboot.mapper" level="DEBUG"/>



使用@Slf4j注解；

    类内直接可使用：log对象；
    
     log.info("error" + user);
            log.warn("warn" + user);
            log.info("info" + user);
            log.debug("debug" + user);
    
    以前需要：
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    logger.error("xxx");
    

使用@Slf4j需要lombok插件


1） lombok依赖

    <dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.2</version>
    </dependency>
    
2）idea 需要安装lombok插件



        