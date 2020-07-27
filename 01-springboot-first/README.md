
#### 开始springboot专题




#### 一 如何识别一个普通的maven模块是springboot工程呢？


springboot项目都有一个parent模块。
        
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.1.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

为springboot项目统一依赖版本控制，插件插件管理。


spring-boot-starter-parent 也是一个pom模块

定义了resources 

    <resources>
      <resource>
        <directory>${basedir}/src/main/resources</directory>
        <filtering>true</filtering>
        <includes>
          <include>**/application*.yml</include>
          <include>**/application*.yaml</include>
          <include>**/application*.properties</include>
        </includes>
      </resource>
      <resource>
        <directory>${basedir}/src/main/resources</directory>
        <excludes>
          <exclude>**/application*.yml</exclude>
          <exclude>**/application*.yaml</exclude>
          <exclude>**/application*.properties</exclude>
        </excludes>
      </resource>
    </resources>    
    
    
spring-boot-starter-parent 也有个父模块


    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-dependencies</artifactId>
        <version>2.3.1.RELEASE</version>
     </parent>
  
定义了依赖的版本。


#### 二 springboot的配置文件注意点

    
    1) 配置文件需要是 application 开头的, 这样才能被编译到类路径下。和 resources插件有关
    
    2) 两种格式的配置文件。 application.properties; application.yml; properties的优先级大一些
    
    3) 多个配置文件切换。 通过spring.profiles.active=name替换配置文件，
        
        name ----> application-name.properties 




#### 三 springboot 自定义配置

    定义自定义配置，然后采用注解的方式读取配置的属性值
    
    1， @Value 读取配置值
    
        在配置文件application-dev.properties中
            
            school.name=清华大学
            school.address=北京海淀
        
        在springboot管理的bean中获取 值
            
             @Value("${school.name}")
             private String schoolName;
       
             @Value("${school.address}")
             private String schoolAddress;    

    2. @ConfigurationProperties
    
        对于多个配置项，可以将它们映射成一个对象。有spring创建和管理。
        
        实现看config.SchoolInfo配置类
        @Component
        @ConfigurationProperties(prefix = "school")
        
        注意：使用@ConfigurationProperties出现警告需要引入依赖：
            
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-configuration-processor</artifactId>
                <optional>true</optional>
            </dependency>
    
        
#### 四 springboot 前端使用jsp


1. 引入依赖


       <!--引入 Spring Boot 内嵌的 Tomcat 对 JSP 的解析包，不加解析不了 jsp 页面-->
            <!--如果只是使用 JSP 页面，可以只添加该依赖-->
            <dependency>
                <groupId>org.apache.tomcat.embed</groupId>
                <artifactId>tomcat-embed-jasper</artifactId>
            </dependency>
            <!--如果要使用 servlet 必须添加该以下两个依赖-->
            <!-- servlet 依赖的 jar 包-->
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>javax.servlet-api</artifactId>
            </dependency>
            <dependency>
                <groupId>javax.servlet.jsp</groupId>
                <artifactId>javax.servlet.jsp-api</artifactId>
                <version>2.3.1</version>
            </dependency>
    
            <!--如果使用 JSTL 必须添加该依赖-->
            <!--jstl 标签依赖的 jar 包 start-->
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>jstl</artifactId>
            </dependency>


2. 配置jsp文件编译到指定目录 META-INF/resources 目录下


    SpringBoot 要求 jsp 文件必须编译到指定的 META-INF/resources 目录下才能访问，否则
    访问不到
    
    <resources>
        <resource>
            <!--源文件位置-->
            <directory>src/main/webapp</directory>
            <!--指定编译到 META-INF/resources，该目录不能随便写-->
            <targetPath>META-INF/resources</targetPath>
            <includes>
                <!--指定要把哪些文件编译进去，**表示 webapp 目录及子目录，*.*表示所有文件-->
                <include>**/*.*</include>
            </includes>
        </resource>
    </resources>


3. 配置视图


    spring.mvc.view.prefix=/WEB-INF/
    spring.mvc.view.suffix=.jsp
    

4. 在 在 src/main  下创建一个 webapp目录

     
     指定该目录为Web Resource Directory； 用于存放jsp 文件。
    
   
   
#### 五: 启动一个springboot ?
        
      启动类使用@SpringbootApplication标识
      
      
      main方法上写上：
        
              SpringApplication.run(SpringbootApplication.class, args);
              
      
      启动类可以实现CommandLineRunner接口，让后实现方法run; run中可以使用自动注入的bean对象。                


































  
      