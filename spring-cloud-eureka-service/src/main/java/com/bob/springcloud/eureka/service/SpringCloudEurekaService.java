package com.bob.springcloud.eureka.service;

import javax.annotation.PostConstruct;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wb-jjb318191
 * @create 2018-06-21 17:14
 */
@Service
public class SpringCloudEurekaService {

    @Autowired
    private ApplicationInfoManager infoManager;

    //@PostConstruct
    public void getInstanceInfo() {
        InstanceInfo instanceInfo = infoManager.getInfo();
        System.out.println(instanceInfo.toString());
    }

}
