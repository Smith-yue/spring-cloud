package com.bob.springcloud.eureka.config;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;

/**
 * @author
 * @create
 */
public class DefaultHealthCheckHandler implements HealthCheckHandler {

    @Override
    public InstanceStatus getStatus(InstanceStatus currentStatus) {
        return currentStatus;
    }
}
