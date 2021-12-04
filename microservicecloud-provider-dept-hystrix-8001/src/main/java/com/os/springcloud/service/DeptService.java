package com.os.springcloud.service;


import com.os.springcloud.entities.Dept;

import java.util.List;

public interface DeptService {

    Dept findDeptById(Long id);

    List<Dept> findAll();
}
