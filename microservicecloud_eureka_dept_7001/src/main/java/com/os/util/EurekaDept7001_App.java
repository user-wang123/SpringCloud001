package com.os.util;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableDiscoveryClient
public class EurekaDept7001_App {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaDept7001_App.class).web(true).run(args);
    }
}
