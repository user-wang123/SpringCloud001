package com.os.springcloud.controller;

import com.os.springcloud.entities.Dept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController_Consumer {

    //定义变量，用于存放通用的部分网址(使用负载均衡之后)
    private static final String REST_URL_PREFIX = "http://WUDONGYUAPP";

    //需要一个提供增删改查方法的对象
    @Resource
    private RestTemplate restTemplate;

    //增加

    //删除

    //修改

    //查询
    @RequestMapping("showDeptALLByConsumer")
    public List<Dept> showDeptALLByConsumer(){
        //需要用一个对象，调用查询方法
        List<Dept> list = restTemplate.getForObject(REST_URL_PREFIX + "/showAll", List.class);
        return list;
    }


    /**
     * 获取提供者子项目中的摘要信息
     */
    @RequestMapping("getServiceInfoByConsumer")
    public Object getServiceInfoByConsumer(){
        Object object = restTemplate.getForObject(REST_URL_PREFIX + "/getServiceInfo", Object.class);
        return object;
    }
}
