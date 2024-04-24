package com.hundsun.fund;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;
import com.hundsun.jrescloud.db.core.configuration.EnableCloudDataSource;

/**
 * @Author
 * @Date 2024/4/19 16:20
 * @Description
 */
@CloudApplication
@EnableCloudDataSource
public class QuestionnaireApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(QuestionnaireApplication.class, args);
    }
}
