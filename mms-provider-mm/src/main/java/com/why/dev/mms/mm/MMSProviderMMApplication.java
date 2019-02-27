/**
 * Project Name: face-recognition-mms
 * File Name: MMSProviderMMApplication.java
 * Package Name: com.why.dev.mms.mm
 * Date: 2019-02-27 23:41
 * Copyright (c) 2019, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.mm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName: MMSProviderMMApplication
 * Description: 会议管理模块启动类
 * Date: 2019-02-27 23:41
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MMSProviderMMApplication {
    public static void main(String[] args) {
        SpringApplication.run(MMSProviderMMApplication.class, args);
    }
}
