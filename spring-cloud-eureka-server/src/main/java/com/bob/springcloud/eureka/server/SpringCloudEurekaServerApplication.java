package com.bob.springcloud.eureka.server;

import com.bob.springcloud.eureka.server.config.ConditionalOnMissingBeanTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.EurekaServerAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * Eureka服务器
 * EnableEurekaServer : 此注解的作用是能标识当前应用可以作为一个EurekaServer
 *
 * @author Administrator
 * @create 2018-06-11 23:12
 * @see EurekaServerAutoConfiguration
 */
@EnableFeignClients
@EnableEurekaServer
@SpringBootApplication
//通过直接和间接的Import引入的Class是有顺序的, 最外层的@Import引入的Class位于解析到的Class集合的最后一位,也就是最晚解析
//其他的位置按类上注解的顺序, EnableEurekaServer >> SpringBootApplication >> Import, 由内而外, 由上而下
// @Conditional系列的注解需要注意Bean的加载顺序
@Import(ConditionalOnMissingBeanTest.class)
public class SpringCloudEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerApplication.class, args);
    }

}
