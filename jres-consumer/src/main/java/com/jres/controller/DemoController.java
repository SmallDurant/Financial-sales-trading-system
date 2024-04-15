package com.jres.controller;

import com.ding.DemoService;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @CloudReference
    private DemoService demoService;

    @GetMapping("/sayHello")
    public String sayHello(){
        return demoService.sayHello();
    }
}
