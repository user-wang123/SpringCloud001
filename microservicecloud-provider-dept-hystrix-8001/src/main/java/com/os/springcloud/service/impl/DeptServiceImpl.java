package com.os.springcloud.service.impl;


import com.os.springcloud.dao.DeptDao;
import com.os.springcloud.entities.Dept;
import com.os.springcloud.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao deptDao;

    @Override
    public Dept findDeptById(Long id) {
        return deptDao.selectDeptById(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.selectAll();
    }
}
