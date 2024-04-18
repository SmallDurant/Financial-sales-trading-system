package com.hundsun.controller;

import com.hundsun.demo.DemoService;
import com.hundsun.jrescloud.rpc.annotation.CloudReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Dding
 * @date: 2024/04/16
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {
    @CloudReference
    private DemoService demoService;

    @GetMapping("/sayHello")
    public String sayHello(){
        return demoService.sayHello();
    }
}
