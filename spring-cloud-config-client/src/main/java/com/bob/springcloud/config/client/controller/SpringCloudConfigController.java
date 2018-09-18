package com.bob.springcloud.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 配置选项：{@link ConfigClientProperties}
 *
 * 配置信息的作用机制：{@link ConfigServicePropertySourceLocator#getRemoteEnvironment(RestTemplate, ConfigClientProperties, String, String)}
 *
 * @author wb-jjb318191
 * @create 2018-06-11 15:14
 * @see ConfigClientProperties
 * @see ConfigServicePropertySourceLocator#getRemoteEnvironment(RestTemplate, ConfigClientProperties, String, String)
 */
@RestController
@RefreshScope
public class SpringCloudConfigController {

    @Value("${foo}")
    String foo;

    @Value("${democonfigclient.message}")
    private String message;

    @RequestMapping(value = "/hi")
    public String hi() {
        return foo;
    }

}
