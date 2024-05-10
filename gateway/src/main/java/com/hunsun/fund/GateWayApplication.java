package com.hunsun.fund;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author
 * @Date 2024/4/19 14:59
 * @Description
 */
@CloudApplication()
public class GateWayApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(GateWayApplication.class, args);
    }
}
