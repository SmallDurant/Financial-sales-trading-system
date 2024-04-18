package com.hundsun;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;

@CloudApplication
public class FundClientApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(FundClientApplication.class, args);
    }
}
