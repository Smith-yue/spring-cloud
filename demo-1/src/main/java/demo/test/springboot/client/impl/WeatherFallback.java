package demo.test.springboot.client.impl;

import demo.test.springboot.client.IWeatherClient;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * @author : songchunyu
 * @version V1.0
 * @Project: spring-cloud
 * @Package demo.test.springboot.client.impl
 * @Description: TODO
 * @date Date : 2019年06月12日 10:13
 */
public class WeatherFallback implements IWeatherClient {
    @Override
    public ResponseEntity<Map> getWeather() {
        return null;
    }
}
