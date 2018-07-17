package com.bob.springcloud.ribbon.service;

import java.util.Map;

import com.bob.springcloud.ribbon.model.User;
import feign.MethodMetadata;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 * @create 2018-06-12 21:02
 */
//@RequestMapping("/feign")
@FeignClient(value = "SERVICE-EUREKA", fallback = FeignServiceRequestFallbackProcessor.class)
public interface FeignServiceRequest {

    /**
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json; charset=UTF-8", headers = "content-type=application/json")
    String sayHelloFromClientOne(@RequestParam(value = "name")  String name);

    /**
     * {@link MethodMetadata#bodyIndex}
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST, headers = "userName=${spring.application.name}")
    void createUser(User user);

    /**
     * {@link MethodMetadata#headerMapIndex},{@link MethodMetadata#queryMapIndex}
     *
     * @param params
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User getUser(@RequestParam("params") Map<String, Object> params, @PathVariable("id") String id);

}