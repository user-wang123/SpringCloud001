package com.os.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

public class MySelfRule {

    @Bean
    public IRule myRule(){
        RandomRule_WDY wdyRule = new RandomRule_WDY();
        return wdyRule;
        //		return new RandomRule();// Ribbon默认是轮询，我自定义为随机
        //return new RoundRobinRule();// Ribbon默认是轮询，我自定义为随机
//		return new RandomRule_ZY();// 我自定义为每台机器5次
    }
}
