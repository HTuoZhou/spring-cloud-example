package com.ywstz.cloud;

import com.ywstz.config.LoadBalancerAnotherProviderConfig;
import com.ywstz.config.LoadBalancerProviderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * TuoZhou
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
// 局部生效，针对特定的loadbalancer客户端
@LoadBalancerClients({
        @LoadBalancerClient(name = "SPRING-CLOUD-PROVIDER-SERVICE", configuration = LoadBalancerProviderConfig.class),
        @LoadBalancerClient(name = "SPRING-CLOUD-ANOTHER-PROVIDER-SERVICE", configuration = LoadBalancerAnotherProviderConfig.class)
})
public class SpringCloudLoadbalancerConsumer8087Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudLoadbalancerConsumer8087Application.class, args);
    }

}
