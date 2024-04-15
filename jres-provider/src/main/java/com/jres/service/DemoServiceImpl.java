package com.jres.service;

import com.ding.DemoService;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;

@CloudComponent
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello() {
        return "Hello Hund-sun";
    }
}
