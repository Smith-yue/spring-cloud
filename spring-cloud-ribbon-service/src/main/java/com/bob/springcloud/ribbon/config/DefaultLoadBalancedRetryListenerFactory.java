package com.bob.springcloud.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalancedRetryListenerFactory;
import org.springframework.retry.RetryListener;
import org.springframework.stereotype.Component;

/**
 * 负载均衡重试监听器创建工厂
 *
 * @author
 * @create 2018-07-18 14:11
 */
@Component
public class DefaultLoadBalancedRetryListenerFactory implements LoadBalancedRetryListenerFactory {

    @Override
    public RetryListener[] createRetryListeners(String service) {
        RetryListener[] listeners = new RetryListener[1];
        listeners[0] = new DefaultRetryListener(service);
        return listeners;
    }
}
