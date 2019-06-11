package com.bob.springcloud.eureka.config;

import com.netflix.discovery.PreRegistrationHandler;

/**
 * @author
 * @create
 */
public class DefailtPreRegistrationHandler implements PreRegistrationHandler {

    @Override
    public void beforeRegistration() {
        System.out.println("开始向Eureka Server注册InstanceInfo");
    }
}
