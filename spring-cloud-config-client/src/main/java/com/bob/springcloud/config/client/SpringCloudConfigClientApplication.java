package com.bob.springcloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.BootstrapConfiguration;
import org.springframework.cloud.config.client.ConfigClientAutoConfiguration;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

/**
 * SpringCloudConfig Client的配置信息都在{@link ConfigClientAutoConfiguration} 里面
 * 通过 spring.factories文件引入
 *
 * 默认初始化时通过 {@link ConfigServicePropertySourceLocator#locate(Environment)} 向Server发送请求
 * 请求发送到
 * @RequestMapping("/{name}/{profiles}/{label:.*}") {@link EnvironmentController#labelled()} 中
 *
 *
 * @author jjb
 * @since 2018-09-12
 */
@BootstrapConfiguration
@SpringBootApplication(scanBasePackages = "com.bob.springcloud.config.client.controller")
public class SpringCloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }
}
