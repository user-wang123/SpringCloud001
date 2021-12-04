package com.springcloud.controller;

import com.os.springcloud.entities.Dept;
import com.os.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("showDeptAllByFeign")
    public List<Dept> showDeptAllByFeign(){
        List<Dept> list = deptClientService.findAll();
        return list;
    }
}
