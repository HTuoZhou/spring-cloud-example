package com.ywstz.cloud.controller;


import com.ywstz.cloud.entity.Consumer;
import com.ywstz.cloud.service.IConsumerService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/seataConsumer")
@Slf4j
public class ConsumerController {

    public static final String SEATA_PROVIDER_BASE_URL = "http://seata-client-provider-service/seata-client-provider/";

    private final IConsumerService consumerService;
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public ConsumerController(IConsumerService consumerService, RestTemplate restTemplate, DiscoveryClient discoveryClient) {
        this.consumerService = consumerService;
        this.restTemplate = restTemplate;
        this.discoveryClient = discoveryClient;
    }

    @PostMapping("/add")
    @GlobalTransactional
    public String add() {
        log.info("seataConsumer init count 100");
        Consumer consumer = new Consumer();
        consumer.setCount(100);
        consumerService.save(consumer);

        // seataProvider add
        String s = restTemplate.postForObject(SEATA_PROVIDER_BASE_URL + "/seataProvider/add/" + consumer.getId(), null, String.class);

        int i = 10 / 0;

        return "seataConsumer init count 100" + "------>" + s;
    }
}
