package com.jres;

import com.hundsun.jrescloud.common.boot.CloudApplication;
import com.hundsun.jrescloud.common.boot.CloudBootstrap;

@CloudApplication
public class ClientApplication {
    public static void main(String[] args) {
        CloudBootstrap.run(ClientApplication.class, args);
    }
}
