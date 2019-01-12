/**
 * Project Name: mms-provider-sm
 * File Name: MMSProviderSMApplication.java
 * Package Name: com.why.dev.mms.sm
 * Date: 2018/12/31 10:32 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.sm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: MMSProviderSMApplication
 * Description: 系统管理模块启动类
 * Date: 2018/12/31 10:32 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MMSProviderSMApplication {
    public static void main(String[] args) {
        SpringApplication.run(MMSProviderSMApplication.class, args);
    }
}
