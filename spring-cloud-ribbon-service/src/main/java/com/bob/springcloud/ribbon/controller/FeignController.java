package com.bob.springcloud.ribbon.controller;

import java.util.HashMap;
import java.util.Map;

import com.bob.springcloud.ribbon.model.User;
import com.bob.springcloud.ribbon.service.FeignServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @create 2018-06-12 21:02
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private FeignServiceRequest serviceRequest;

    @GetMapping("/hello")
    public String sayHello(String name) {
        return serviceRequest.sayHelloFromClientOne(name);
    }

    @GetMapping("/user")
    public User getUser(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return serviceRequest.getUser(params, "123");
    }

    //@GetMapping("/zuul/{name}")
    public String accpetZuulRequest(@PathVariable String name) {
        return String.format("%s接受%s的请求", applicationName, name);
    }

}
