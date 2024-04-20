package com.hundsun.fund;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;

/**
 * @Author
 * @Date 2024/4/19 14:20
 * @Description
 */
@EnableCloudDataSource
@CloudApplication
public class UserApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(UserApplication.class, args);
    }
}
