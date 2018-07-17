package com.bob.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Eureka服务提供者
 *
 * @author wb-jjb318191
 * @create 2018-06-12 14:46
 */
// 此注解的作用是引入 EurekaDiscoveryClientConfiguration 类
//@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.bob.springcloud.eureka")
public class SpringCloudEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServiceApplication.class, args);
    }

}
