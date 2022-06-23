package com.ywstz.cloud;

import com.ywstz.config.RibbonAnotherProviderConfig;
import com.ywstz.config.RibbonProviderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * TuoZhou
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
// 局部生效，针对特定的ribbon客户端
@RibbonClients({
        @RibbonClient(name = "SPRING-CLOUD-PROVIDER-SERVICE", configuration = RibbonProviderConfig.class),
        @RibbonClient(name = "SPRING-CLOUD-ANOTHER-PROVIDER-SERVICE", configuration = RibbonAnotherProviderConfig.class)
})
public class SpringCloudRibbonConsumer8084Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonConsumer8084Application.class, args);
    }

}
