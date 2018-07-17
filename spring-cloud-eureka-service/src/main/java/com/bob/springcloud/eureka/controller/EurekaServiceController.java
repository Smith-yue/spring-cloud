package com.bob.springcloud.eureka.controller;

import javax.annotation.PostConstruct;

import com.netflix.loadbalancer.ILoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.ribbon.PropertiesFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wb-jjb318191
 * @create 2018-06-12 9:26
 */
@RestController
public class EurekaServiceController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private PropertiesFactory propertiesFactory;

    @PostConstruct
    public void init() {
        boolean isSet = propertiesFactory.isSet(ILoadBalancer.class, "NFLoadBalancerClassName");
        System.out.println(isSet);
    }

    @RequestMapping("/hello")
    public String home(@RequestParam String name) {
        return "hello " + name + ",从组件EurekaService, port:" + port + "返回结果";
    }

}
