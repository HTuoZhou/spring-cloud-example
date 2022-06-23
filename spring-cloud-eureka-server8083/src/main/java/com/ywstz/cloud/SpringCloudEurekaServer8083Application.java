package com.ywstz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author TuoZhou
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServer8083Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServer8083Application.class, args);
    }

}
