package com.hy.springcloud.service;

import com.hy.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author ：hongyan
 * @date ：Created in 2022/10/3 17:35
 * @description：部门Service
 */
public interface DeptService {
    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
