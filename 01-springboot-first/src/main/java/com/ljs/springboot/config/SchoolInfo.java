package com.ljs.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * create by ljs on 2020/7/24 16:37
 * description:  这是一个配置类； 将配置文件映射成一个java对象
 *
 */

@Component
@ConfigurationProperties(prefix = "school")
public class SchoolInfo {

    private String name;
    private String address;
    private String profile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "SchoolInfo{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", profile='" + profile + '\'' + '}';
    }
}
