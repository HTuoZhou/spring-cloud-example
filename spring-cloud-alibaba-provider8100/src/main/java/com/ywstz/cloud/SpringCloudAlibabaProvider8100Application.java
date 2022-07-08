package com.ywstz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TuoZhou
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaProvider8100Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaProvider8100Application.class, args);
    }

}
