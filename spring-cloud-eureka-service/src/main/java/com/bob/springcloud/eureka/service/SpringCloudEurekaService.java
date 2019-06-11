package com.bob.springcloud.eureka.service;

import javax.annotation.PostConstruct;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author
 * @create
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
