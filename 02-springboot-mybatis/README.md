

### springboot 整合 mybatis


###### 1. mybatis依赖
    
    <!--MyBatis 整合 SpringBoot 的起步依赖-->
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.0.0</version>
    </dependency>

###### 2. mysql驱动依赖

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>


###### 3. 配置数据源
    
    注意： username/password不要选错了。‘
    
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://127.0.0.1:3306/crm?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=root


###### 4. 编写mapper接口 和mapper映射

    这里可以通过mybatis逆向工程生成基本的单表操作，
    
    注意： 
        1）如果查询返回是对象，最好返回类型定义为 resultMap；而不是 resultType
        

###### 5. 在启动类上；添加注解 @MapperScan("xxxxx.xx.xx.mapper")        
        

###### 出现异常：org.apache.ibatis.binding.BindingException原因总结

简单说 接口方法和mapper映射sql没有绑定。
    
    1） 如果mapper映射文件在 src/main/java/xxx/mapper/ 包下
    
        需要定义 在pom中定义resources插件，为了编译后mapper.xml和mapper接口在同一目录下。
    
    
    






