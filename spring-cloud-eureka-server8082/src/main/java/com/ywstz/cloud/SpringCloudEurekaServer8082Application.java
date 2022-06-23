package com.ywstz.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author TuoZhou
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServer8082Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServer8082Application.class, args);
    }

}
