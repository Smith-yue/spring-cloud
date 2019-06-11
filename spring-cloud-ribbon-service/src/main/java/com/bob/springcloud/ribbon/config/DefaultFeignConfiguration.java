package com.bob.springcloud.ribbon.config;

import com.bob.springcloud.ribbon.service.FeignService;
import com.bob.springcloud.ribbon.service.FeignServiceFallbackProcessor;
import feign.Feign;
import feign.hystrix.HystrixFeign;
import org.springframework.context.annotation.Bean;

/**
 * @author
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
    public FeignService feignServiceRequestFallback() {
        return new FeignServiceFallbackProcessor();
    }

}
