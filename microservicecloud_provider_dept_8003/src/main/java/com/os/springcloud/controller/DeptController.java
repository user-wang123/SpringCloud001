package com.os.springcloud.controller;


import com.os.springcloud.entities.Dept;
import com.os.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Resource
    private DiscoveryClient zzclient;

    @RequestMapping("showAll")
    public List<Dept> showAll(){
        List<Dept> list = deptService.findAll();
        return list;
    }


    /**
     * 拿到当前微服务的摘要信息
     */
    @RequestMapping("getServiceInfo")
    public Object getServiceInfo(){
        //通过一个对象来调用具体的服务方法
        List<String> list = zzclient.getServices();
        System.out.println("list:" + list);
        List<ServiceInstance> appList = zzclient.getInstances("wudongyuApp");
        for (ServiceInstance si : appList){
            System.out.println("Host : " + si.getHost());
            System.out.println("Port : " + si.getPort());
            System.out.println("ServiceId : " + si.getServiceId());
            System.out.println("Uri : " + si.getUri());
            System.out.println("Metadata : " + si.getMetadata());
        }
        return this.zzclient;
    }


}
