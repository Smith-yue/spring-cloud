package com.bob.springcloud.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 * @create 2018-06-12 19:51
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-EUREKA/hello?name=" + name, String.class);
    }

    public String helloError(String name) {
        return "你好," + name + ",从Ribbon调用失败";
    }

}
