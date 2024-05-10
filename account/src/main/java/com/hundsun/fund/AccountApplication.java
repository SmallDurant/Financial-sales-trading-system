package com.hundsun.fund;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;

/**
 * @Author
 * @Date 2024/5/6 下午1:46
 * @Description
 */
@CloudApplication
public class AccountApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(AccountApplication.class, args);
    }
}
