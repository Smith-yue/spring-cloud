package com.bob.springcloud.eureka.config;

import com.netflix.discovery.CacheRefreshedEvent;
import com.netflix.discovery.EurekaEvent;
import com.netflix.discovery.EurekaEventListener;
import com.netflix.discovery.StatusChangeEvent;

/**
 * @author
 * @create
 */
public class DefaultEurekaEventListener implements EurekaEventListener {

    @Override
    public void onEvent(EurekaEvent event) {
        if (event instanceof CacheRefreshedEvent) {
            System.out.println("Eureka环境发生变化,重新生成相关Bean");
        } else if (event instanceof StatusChangeEvent) {
            StatusChangeEvent sce = (StatusChangeEvent)event;
            System.out.println(String.format("应用状态发生变化,之前状态:[%s],当前状态:[%s]", sce.getPreviousStatus().name(), sce.getStatus().name()));
        }
    }
}
