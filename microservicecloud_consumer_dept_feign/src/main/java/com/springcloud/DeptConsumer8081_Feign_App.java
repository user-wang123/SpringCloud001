package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.os.springcloud"})
public class DeptConsumer8081_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8081_Feign_App.class, args);
    }
}
