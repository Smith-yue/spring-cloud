package com.bob.springcloud.ribbon.controller;

import com.bob.springcloud.ribbon.model.User;
import com.bob.springcloud.ribbon.service.FeignService;
import com.bob.springcloud.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.named.NamedContextFactory;
import org.springframework.cloud.netflix.ribbon.PropertiesFactory;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClientSpecification;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.netflix.ribbon.eureka.EurekaRibbonClientConfiguration;
import org.springframework.cloud.netflix.ribbon.eureka.RibbonEurekaAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @create 2018-06-12 14:50
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private RibbonService ribbonService;

    @Autowired
    private FeignService feignService;

    /**
     * Ribbon为每一个{@link com.netflix.discovery.shared.Application} 创建一个{@link SpringClientFactory#getContext(String)},key 就是应用名称
     * 在通过SpringClientFactory 获取指定应用的配置容器时,会首选注册{@link NamedContextFactory#configurations} 里应用名称相同的配置类, 然后注册 "default."
     * 开头的配置类，最后注册{@link NamedContextFactory#defaultConfigType} 默认的配置类
     * 也就是说如果自定义{@link RibbonClientSpecification} 一个Bean, 注册到Spring容器,且指定{@link RibbonClientSpecification#getName()} 为应用名称
     * 那么它会首先被注册入Ribbon配置容器中,可以指定相应的配置组件,这样就能覆盖后续的配置,因为他们都是 "@Conditional" 的
     * 当然也可以在Enviroument里定义应用的配置Bean,详见{@link PropertiesFactory}
     *
     * 也就是说如下三个配置的注册顺序是：RibbonAutoConfiguration  >>  EurekaRibbonClientConfiguration  >>  RibbonClientConfiguration
     *
     * 当配置Bean有相同时, 优先级为： PropertiesFactory配置  >>  自定义 RibbonClientSpecification  >>  EurekaRibbonClientConfiguration  >>  RibbonClientConfiguration
     *
     * @see RibbonAutoConfiguration 没有引入配置类,忽略
     * @see RibbonEurekaAutoConfiguration 引入 {@link EurekaRibbonClientConfiguration}
     * @see RibbonClientConfiguration
     * @see SpringClientFactory#SpringClientFactory()
     */
    @Autowired
    private SpringClientFactory clientFactory;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return ribbonService.hiService(name);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return feignService.getUser(id);
    }

    @GetMapping("/user")
    public Integer createUser() {
        User user = new User();
        user.setName("bob");
        user.setAge(30);
        return feignService.createUser(user);
    }

}
