package com.bob.springcloud.ribbon.service;

import com.bob.springcloud.ribbon.model.User;

/**
 * @author wb-jjb318191
 * @create 2018-06-13 10:37
 */
public class FeignServiceFallbackProcessor implements FeignService {

    @Override
    public String sayHelloFromClientOne(String name) {
        return String.format("你好 %s,从Feign调用失败", name);
    }

    @Override
    public Integer createUser(User user) {
        return null;
    }

    @Override
    public User getUser(Integer id) {
        return null;
    }

}
