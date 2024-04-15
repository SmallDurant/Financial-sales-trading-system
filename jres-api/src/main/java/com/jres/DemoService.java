package com.jres;

import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

@CloudService
public interface DemoService {
    @CloudFunction("33333")
    public String sayHello();
}
