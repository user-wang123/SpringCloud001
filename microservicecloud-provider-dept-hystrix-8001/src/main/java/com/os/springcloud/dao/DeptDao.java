package com.os.springcloud.dao;


import com.os.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    List<Dept> selectAll();

    Dept selectDeptById(Long id);
}
