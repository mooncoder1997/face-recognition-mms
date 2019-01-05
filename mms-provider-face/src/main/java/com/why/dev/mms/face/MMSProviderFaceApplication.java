/**
 * Project Name: mms-provider-face
 * File Name: MMSProviderFaceApplication.java
 * Package Name: com.why.dev.mms.face
 * Date: 2018/12/23 8:44 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.face;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: MMSProviderFaceApplication
 * Description: 面部信息管理模块启动类
 * Date: 2018/12/23 8:44 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MMSProviderFaceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MMSProviderFaceApplication.class, args);
    }
}
