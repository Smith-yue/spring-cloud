package com.bob.springcloud.ribbon.config;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

/**
 * 重试监听器
 *
 * @author wb-jjb318191
 * @create 2018-07-18 14:09
 */
public class DefaultRetryListener extends RetryListenerSupport {

    private String serviceId;

    public DefaultRetryListener(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        System.out.println(String.format("***********尝试调用服务[%s]失败***********", serviceId));
    }
}
