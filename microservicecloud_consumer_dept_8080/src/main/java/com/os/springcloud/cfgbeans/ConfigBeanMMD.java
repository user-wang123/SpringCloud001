package com.os.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBeanMMD {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplateWdy(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
