package com.bob.springcloud.ribbon;

import com.bob.springcloud.ribbon.config.DefaultRibbonClientConfig;
import com.netflix.client.DefaultLoadBalancerRetryHandler;
import com.netflix.client.RetryHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClientConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.ribbon.CachingSpringLoadBalancerFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * {@link EnableEurekaClient}的作用仅仅是指明当前应用引入了Eureka-Client的依赖,其配置信息会有{@link EnableAutoConfiguration} 来自动引入
 *
 * {@link EnableFeignClients}指定扫描那些标识了{@link FeignClient} 的接口,机制和{@link ComponentScan} 一致
 * 当然也可以通过{@link EnableFeignClients#defaultConfiguration()} 来指定默认配置,效果和 {@link RibbonClients#defaultConfiguration()}一致
 * 若 {@link EnableFeignClients#clients()}不为空,那么禁止{@link FeignClient} 扫描
 *
 * @author wb-jjb318191
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@RibbonClient(value = "SERVICE-EUREKA", configuration = DefaultRibbonClientConfig.class)
public class SpringCloudRibbonServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
