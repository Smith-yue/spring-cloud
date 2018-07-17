package com.bob.springcloud.eureka.config;

import com.netflix.discovery.PreRegistrationHandler;

/**
 * @author wb-jjb318191
 * @create 2018-07-03 14:50
 */
public class DefailtPreRegistrationHandler implements PreRegistrationHandler {

    @Override
    public void beforeRegistration() {
        System.out.println("开始向Eureka Server注册InstanceInfo");
    }
}
