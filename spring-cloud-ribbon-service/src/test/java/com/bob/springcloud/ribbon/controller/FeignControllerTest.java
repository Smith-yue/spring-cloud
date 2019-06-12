//package com.bob.springcloud.ribbon.controller;
//
//import com.bob.springcloud.ribbon.config.BaseControllerTest;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class FeignControllerTest extends BaseControllerTest {
//
//    @Autowired
//    private FeignController feignController;
//
//    @Override
//    protected void init() {
//        super.mappedController = feignController;
//    }
//
//    @Test
//    public void sayHello() throws Exception {
//        getRequest("/feign/hello?name=lanboal", "");
//    }
//
//}