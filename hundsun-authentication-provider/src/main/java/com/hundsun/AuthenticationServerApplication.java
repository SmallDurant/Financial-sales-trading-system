package com.hundsun;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;


@EnableCloudDataSource
@CloudApplication
public class AuthenticationServerApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(AuthenticationServerApplication.class, args);
    }
}
