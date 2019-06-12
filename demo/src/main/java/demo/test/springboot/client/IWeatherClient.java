package demo.test.springboot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author : songchunyu
 * @version V1.0
 * @Project: spring-cloud
 * @Package demo.test.springboot.client
 * @Description: TODO
 * @date Date : 2019年06月12日 10:11
 */
@FeignClient(name = "data", url = "${feign.client.url}")
public interface IWeatherClient {

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<Map> getWeather();

}