package com.bob.springcloud.eureka.server.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @create 2018-07-03 10:10
 */
@Configuration
public class ZipkinConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ConditionalOnMissingBeanTest configOnMissingBeanTest(){
        System.out.println("测试********************");
        return new ConditionalOnMissingBeanTest();
    }

}
