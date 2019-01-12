/**
 * Project Name: face-recognition-mms
 * File Name: MMSDiscoveryEurekaApplication.java
 * Package Name: com.why.dev.mms.discovery
 * Date: 2018/12/23 5:46 PM
 * Copyright (c) 2018, Wang, Haoyue All Rights Reserved.
 */
package com.why.dev.mms.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * ClassName: MMSDiscoveryEurekaApplication
 * Description: 微服务注册中心
 * Date: 2018/12/23 5:46 PM
 *
 * @author Wang, Haoyue
 * @version V1.0
 * @since JDK 1.8
 */
@EnableEurekaServer
@SpringBootApplication
public class MMSDiscoveryEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MMSDiscoveryEurekaApplication.class, args);
    }
}
