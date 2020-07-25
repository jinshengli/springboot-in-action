
#### mybatis的逆向工程


通过mybatis-generator插件为我们生成`实体类`和`mapper接口`和对应的`mapper映射文件`。


##### 步骤


###### 1. 导入mybatis-generator插件

    
    <!--mybatis 代码自动生成插件-->
    <plugin>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>1.3.6</version>
        <configuration>
            <!--配置文件的位置-->
            <configurationFile>GeneratorMapper.xml</configurationFile>
            <verbose>true</verbose>
            <overwrite>true</overwrite>
        </configuration>
    </plugin>


###### 2. 创建GeneratorMapper.xml配置文件

注意：名字必须是`GeneratorMapper.xml`；和`pom.xml`平级目录下。

大概配置内容包括：

1） jdbc驱动包；
    
    <classPathEntry location=“xxx” />
    去找maven仓库就行
    
2）和数据库连接的信息
    
    <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                    connectionURL="jdbc:mysql://localhost:3306/crm?nullCatalogMeansCurrent=true"
                    userId="root"
                    password="root">
    </jdbcConnection>

3) 定义生成的`实体类`放在对应的`目录`和`包`


    <javaModelGenerator targetPackage="com.ljs.springboot.model"
                        targetProject="src/main/java">
        <property name="enableSubPackages" value="false" />
        <property name="trimStrings" value="false" />
    </javaModelGenerator>
    

4) 定义生成的`mapper接口`放在对应的`目录`和`包`

    
    <javaClientGenerator type="XMLMAPPER"
                         targetPackage="com.ljs.springboot.mapper" 
                         targetProject="src/main/java">
        <property name="enableSubPackages" value="false" />
    </javaClientGenerator>

5) 定义生成的`mapper映射文件`放在对应的`目录`和`包`

    
    <sqlMapGenerator targetPackage="com.ljs.springboot.mapper"
                   targetProject="src/main/java">
        <property name="enableSubPackages" value="false" />
    </sqlMapGenerator>
    
    
6) 定义`哪些表`需要生成`实体类、mapper接口、mapper映射文件`


    <!-- 数据库表名及对应的 Java 模型类名 -->
    <table tableName="tbl_user" domainObjectName="User"
           enableCountByExample="false"
           enableUpdateByExample="false"
           enableDeleteByExample="false"
    enableSelectByExample="false"
    selectByExampleQueryId="false"/>    
    

###### 最后别忘了maven的 resources插件

    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
        </resource>
    </resources>    