package com.bob.springcloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.config.ConfigServerProperties;
import org.springframework.cloud.config.server.environment.EnvironmentController;
import org.springframework.core.env.Environment;

/**
 * 配置选项：{@link ConfigServerProperties}
 * 默认情况下Client初始化时通过
 * {@link ConfigServicePropertySourceLocator#locate(Environment)}
 * 向Server发送请求
 *
 * @RequestMapping("/{name}/{profiles}/{label:.*}") {@link EnvironmentController#labelled(String, String, String)} 中,
 */
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServerApplication.class, args);
    }
}
