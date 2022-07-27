package com.ywstz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TuoZhou
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaSeataProvider8103Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaSeataProvider8103Application.class, args);
    }

}
