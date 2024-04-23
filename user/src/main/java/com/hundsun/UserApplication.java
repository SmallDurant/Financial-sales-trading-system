package com.hundsun;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author
 * @Date 2024/4/19 14:20
 * @Description
 */
@EnableCloudDataSource
@CloudApplication()
@ComponentScan(basePackages = {"com.hundsun.*"})
public class UserApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(UserApplication.class, args);
    }
}
