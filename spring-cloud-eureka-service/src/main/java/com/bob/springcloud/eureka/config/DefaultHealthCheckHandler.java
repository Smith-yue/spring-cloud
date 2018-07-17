package com.bob.springcloud.eureka.config;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;

/**
 * @author wb-jjb318191
 * @create 2018-07-03 14:31
 */
public class DefaultHealthCheckHandler implements HealthCheckHandler {

    @Override
    public InstanceStatus getStatus(InstanceStatus currentStatus) {
        return currentStatus;
    }
}
