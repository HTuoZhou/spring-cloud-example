package com.ywstz.cloud.controller;


import com.ywstz.cloud.entity.Consumer;
import com.ywstz.cloud.service.IConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

    // public static final String PROVIDER_BASE_URL = "http://localhost:8080/spring-cloud-provider/";
    public static final String PROVIDER_BASE_URL = "http://SPRING-CLOUD-PROVIDER-SERVICE/spring-cloud-provider/";

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
        log.info("consumer init count 100");
        Consumer consumer = new Consumer();
        consumer.setCount(100);
        consumerService.save(consumer);

        // provider add
        String s = restTemplate.postForObject(PROVIDER_BASE_URL + "/provider/add/" + consumer.getId(), null, String.class);

        return "consumer init count 100" + "------>" + s;
    }

    @GetMapping("/timeout/{time}")
    public String timeout(@PathVariable Long time) {
        log.info("consumer timeout " + time + "s");

        // provider timeout
        String s = restTemplate.getForObject(PROVIDER_BASE_URL + "/provider/timeout/" + time, String.class);

        return "consumer timeout " + time + "s" + "------>" + s;
    }
}
