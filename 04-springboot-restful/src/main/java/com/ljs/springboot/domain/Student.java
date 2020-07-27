package com.ljs.springboot.domain;



import java.io.Serializable;

/**
 * create by ljs on 2020/7/25 19:24
 * description:
 */


public class Student implements Serializable {

    private String id;
    private String name;
    private Integer age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
