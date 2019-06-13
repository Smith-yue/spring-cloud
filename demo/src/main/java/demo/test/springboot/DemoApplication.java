package demo.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bootstrap.BootstrapConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@BootstrapConfiguration
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "demo.test.springboot")
@EnableFeignClients(basePackages = {"demo.test.springboot.client",
		"demo.test.springboot.controller"})
@EnableDiscoveryClient // 该注解会根据配置文件中的地址，将服务自身注册到服务注册中心

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
