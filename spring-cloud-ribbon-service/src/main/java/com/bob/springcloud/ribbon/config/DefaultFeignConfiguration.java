package com.bob.springcloud.ribbon.config;

import com.bob.springcloud.ribbon.service.FeignServiceRequest;
import com.bob.springcloud.ribbon.service.FeignServiceRequestFallbackProcessor;
import feign.Feign;
import feign.hystrix.HystrixFeign;
import org.springframework.context.annotation.Bean;

/**
 * @author wb-jjb318191
 * @create 2018-07-19 16:52
 */
public class DefaultFeignConfiguration {

    /**
     * 指定使用HystrixFeign 的Builder
     *
     * @return
     */
    @Bean
    public Feign.Builder feignBuilder() {
        return new HystrixFeign.Builder();
    }

    /**
     * 指定回退实现
     *
     * @return
     */
    @Bean
    public FeignServiceRequest feignServiceRequestFallback() {
        return new FeignServiceRequestFallbackProcessor();
    }

}
