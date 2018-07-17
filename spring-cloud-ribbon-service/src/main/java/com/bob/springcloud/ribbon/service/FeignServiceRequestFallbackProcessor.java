package com.bob.springcloud.ribbon.service;

import java.util.Map;

import com.bob.springcloud.ribbon.model.User;
import org.springframework.stereotype.Component;

/**
 * @author wb-jjb318191
 * @create 2018-06-13 10:37
 */
public class FeignServiceRequestFallbackProcessor implements FeignServiceRequest {

    @Override
    public String sayHelloFromClientOne(String name) {
        return String.format("你好 %s,从Feign调用失败", name);
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public User getUser(Map<String, Object> params, String id) {
        return null;
    }

}
