package com.os.springcloud.service;

import com.os.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "WUDONGYUAPP")
public interface DeptClientService {


    @RequestMapping("showAll")
    List<Dept> findAll();
}
