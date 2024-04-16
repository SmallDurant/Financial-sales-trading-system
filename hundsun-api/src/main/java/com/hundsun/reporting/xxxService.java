package com.hundsun.reporting;

import com.hundsun.jrescloud.rpc.annotation.CloudFunction;
import com.hundsun.jrescloud.rpc.annotation.CloudService;

@CloudService
public interface xxxService {
    @CloudFunction("xxx")
    public String sayHello();
}
