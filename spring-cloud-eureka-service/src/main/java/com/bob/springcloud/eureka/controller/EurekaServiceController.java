package com.bob.springcloud.eureka.controller;

import javax.annotation.PostConstruct;
import javax.ws.rs.POST;

import com.bob.springcloud.eureka.model.User;
import com.netflix.loadbalancer.ILoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.ribbon.PropertiesFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("lanboal");
        user.setAge(30);
        return user;
    }

    @PostMapping("/user")
    public Integer createUser(@RequestBody User user, @RequestHeader("userName") String appName) {
        System.out.println(String.format("接收到来自[%s]的请求,内容[%s]", appName, user.getName()));
        return 100;
    }

}
