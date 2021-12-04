package com.os.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.os.springcloud.entities.Dept;
import com.os.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping(value = "getDeptById/{id}", method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept getDeptById(@PathVariable("id") Long id)
    {
        Dept dept = deptService.findDeptById(id);
        if (null == dept) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
        return dept;
    }


    /**
     * 当要查询的编号，在数据库中没有对象的信息时，调用该方法
     * @param id
     * @return
     */
    public Dept processHystrix_Get(@PathVariable("id") Long id)
    {
        return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应的信息,null--@HystrixCommand")
                .setDb_source("no this database in MySQL");
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
