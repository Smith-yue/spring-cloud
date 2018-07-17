package com.bob.springcloud.ribbon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wb-jjb318191
 * @create 2018-06-14 9:18
 */
@RestController
@RequestMapping("/zipkin")
public class ZipkinController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZipkinController.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String home() {
        LOGGER.info("hi is being called");
        return "hi i'm miya!";
    }

    @RequestMapping("/miya")
    public String info() {
        LOGGER.info("info is being called");
        String result = restTemplate.getForObject("http://localhost:8988/info", String.class);
        return result;
    }

}
