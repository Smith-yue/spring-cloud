package com.bob.springcloud.eureka.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.discovery.EurekaEventListener;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.LoggingFilter;
import org.springframework.cloud.netflix.eureka.MutableDiscoveryClientOptionalArgs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Eureka拓展配置
 *
 * @author
 * @create
 */
@Configuration
public class EurekaClientExtConfiguration {

    @Bean
    public MutableDiscoveryClientOptionalArgs discoveryClientOptionalArgs() {
        MutableDiscoveryClientOptionalArgs optionalArgs = new MutableDiscoveryClientOptionalArgs();
        // 设置Eureka客户端过滤器
        Set<ClientFilter> additionalFilters = new HashSet<>();
        additionalFilters.add(new LoggingFilter());
        //additionalFilters.add(new DefaultClientFilter());
        optionalArgs.setAdditionalFilters(additionalFilters);
        // 设置Eureka事件监听器
        Set<EurekaEventListener> listeners = new HashSet<>();
        listeners.add(new DefaultEurekaEventListener());
        optionalArgs.setEventListeners(listeners);
        // 设置注册前的处理器
        optionalArgs.setPreRegistrationHandler(new DefailtPreRegistrationHandler());
        return optionalArgs;
    }

    /**
     * 生命状态验证处理器
     *
     * @return
     */
    @Bean
    public HealthCheckHandler healthCheckHandler() {
        return new DefaultHealthCheckHandler();
    }

}
