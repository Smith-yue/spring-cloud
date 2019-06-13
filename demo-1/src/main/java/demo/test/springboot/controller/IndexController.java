package demo.test.springboot.controller;

import demo.test.springboot.client.IWeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author : songchunyu
 * @version V1.0
 * @Project: spring-cloud
 * @Package demo.test.springboot.controller
 * @Description: TODO
 * @date Date : 2019年06月12日 9:37
 */
@RestController
public class IndexController {

    private final IWeatherClient weatherClient;

    @Autowired
    public IndexController(IWeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @GetMapping(path = "/weather")
    ResponseEntity<Map> getWeather() {
        return ResponseEntity.ok(weatherClient.getWeather().getBody());
    }

    @GetMapping("/index")
    public String index(){
        return "hello world !";
    }
}
