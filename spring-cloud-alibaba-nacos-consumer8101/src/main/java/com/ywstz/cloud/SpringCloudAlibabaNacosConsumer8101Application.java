package com.ywstz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TuoZhou
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaNacosConsumer8101Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaNacosConsumer8101Application.class, args);
    }

}
