package com.bob.springcloud.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author
 * @create 2018-07-10 16:12
 */
@Configuration
public class DefaultRibbonClientConfig {

    /**
     * 自定义负载均衡准则
     *
     * @return
     */
    @Bean
    public IRule ribbonRule() {
        return new RoundRobinRule();
    }
}
