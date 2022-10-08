package com.hy.springcloud.controller;

import com.hy.springcloud.pojo.Dept;
import com.hy.springcloud.service.DeptService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.image.BadDepthException;

import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/10/3 17:39
 * @description：deptController
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }
}
