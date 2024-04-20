package com.hundsun.fund;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;

/**
 * @Author
 * @Date 2024/4/19 16:22
 * @Description
 */
@CloudApplication
@EnableCloudDataSource
public class TransactionApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(TransactionApplication.class, args);
    }
}
