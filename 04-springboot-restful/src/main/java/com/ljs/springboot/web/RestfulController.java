package com.ljs.springboot.web;

import com.ljs.springboot.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

/**
 * create by ljs on 2020/7/25 19:21
 * description:
 */


@RestController
public class RestfulController {

    private ConcurrentHashMap<String, Student> map = new ConcurrentHashMap<>();


    @PostMapping("/student")
    public String addStudent(@RequestBody Student student) {
        System.out.println("添加了student:" + student);
        map.put(student.getId(), student);
        return "添加了student:" + student;
    }

    @RequestMapping(value = "/student01", method = RequestMethod.POST)
    // produces = "application/json;charset=UTF-8"
    public String addStudent01(@RequestBody Student student) {
        System.out.println("添加了student:" + student);
        return "添加了student:" + student;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable(value = "id") String id) {

        System.out.println("查询到student:" + map.get(id));
        return map.get(id);
    }


    @DeleteMapping("/student/{id}")
    public Student deleteStudent(@PathVariable(value = "id") String id) {

        Student student = map.get(id);
        System.out.println("删除student" + student);
        map.remove(id);
        return student;

    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable(value = "id") String id, @RequestBody Student student) {
        System.out.println("修改前：" + map.get(id));
        map.put(id, student);
        System.out.println("修改后：" + map.get(id));
        return student;
    }



}
