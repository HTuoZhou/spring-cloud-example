package com.ywstz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TuoZhou
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaProvider8099Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaProvider8099Application.class, args);
    }

}
