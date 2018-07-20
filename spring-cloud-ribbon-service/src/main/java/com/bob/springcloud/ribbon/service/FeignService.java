package com.bob.springcloud.ribbon.service;

import com.bob.springcloud.ribbon.model.User;
import feign.MethodMetadata;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Administrator
 * @create 2018-06-12 21:02
 */
//@RequestMapping("/feign")
@FeignClient(value = "SERVICE-EUREKA", fallback = FeignServiceFallbackProcessor.class)
public interface FeignService {

    /**
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json; charset=UTF-8", headers = "content-type=application/json")
    String sayHelloFromClientOne(@RequestParam(value = "name") String name);

    /**
     * {@link MethodMetadata#bodyIndex}
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/user", headers = "userName=${spring.application.name}")
    Integer createUser(User user);

    /**
     * {@link MethodMetadata#headerMapIndex},{@link MethodMetadata#queryMapIndex}
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/user/{id})")
    User getUser(@PathVariable("id") Integer id);

}