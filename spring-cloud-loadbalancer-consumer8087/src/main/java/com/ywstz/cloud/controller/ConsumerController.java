package com.ywstz.cloud.controller;


import com.ywstz.cloud.entity.Consumer;
import com.ywstz.cloud.service.IConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <p>
 * 消费表 前端控制器
 * </p>
 *
 * @author TuoZhou
 * @since 2022-06-22
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {
    public static final String PROVIDER_BASE_URL = "http://SPRING-CLOUD-PROVIDER-SERVICE/spring-cloud-provider/";
    public static final String ANOTHER_PROVIDER_BASE_URL = "http://SPRING-CLOUD-ANOTHER-PROVIDER-SERVICE/spring-cloud-another-provider/";

    private final IConsumerService consumerService;
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public ConsumerController(IConsumerService consumerService, RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.consumerService = consumerService;
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    @PostMapping("/add")
    public String add() {
        log.info("loadbalancer consumer count init 100");
        Consumer consumer = new Consumer();
        consumer.setCount(100);
        consumerService.save(consumer);

        // provider add
        String s = restTemplate.postForObject(PROVIDER_BASE_URL + "/provider/add/" + consumer.getId(), null, String.class);

        return "loadbalancer consumer count init 100" + "------>" + s;
    }

    @PostMapping("/reduce/{id}")
    public String reduce(@PathVariable Long id) {
        log.info("loadbalancer consumer count reduce ");
        Consumer consumer = consumerService.getById(id);
        consumer.setCount(consumer.getCount() - 1);
        consumerService.updateById(consumer);

        // provider reduce
        String s = restTemplate.postForObject(PROVIDER_BASE_URL + "/provider/reduce/" + id, null, String.class);

        return "loadbalancer consumer count reduce 1" + "------>" + s;
    }

    @PostMapping("/another/add")
    public String anotherAdd() {
        log.info("loadbalancer consumer count init 100");
        Consumer consumer = new Consumer();
        consumer.setCount(100);
        consumerService.save(consumer);

        // provider add
        String s = restTemplate.postForObject(ANOTHER_PROVIDER_BASE_URL + "/provider/add/" + consumer.getId(), null, String.class);

        return "loadbalancer consumer count init 100" + "------>" + s;
    }

    @PostMapping("/another/reduce/{id}")
    public String anotherReduce(@PathVariable Long id) {
        log.info("loadbalancer consumer count reduce ");
        Consumer consumer = consumerService.getById(id);
        consumer.setCount(consumer.getCount() - 1);
        consumerService.updateById(consumer);

        // provider reduce
        String s = restTemplate.postForObject(ANOTHER_PROVIDER_BASE_URL + "/provider/reduce/" + id, null, String.class);

        return "loadbalancer consumer count reduce 1" + "------>" + s;
    }

    @GetMapping("/discoveryClient")
    public Object discoveryClient() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service:" + "------>" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRING-CLOUD-PROVIDER-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

}
