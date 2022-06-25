package com.ywstz.cloud.controller;


import com.ywstz.cloud.entity.Consumer;
import com.ywstz.cloud.service.IConsumerService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/loadbalancerConsumer")
@Slf4j
public class ConsumerController {
    public static final String PROVIDER_BASE_URL = "http://SPRING-CLOUD-PROVIDER-SERVICE/spring-cloud-provider/";
    public static final String ANOTHER_PROVIDER_BASE_URL = "http://SPRING-CLOUD-ANOTHER-PROVIDER-SERVICE/spring-cloud-another-provider/";

    private final IConsumerService consumerService;
    private final RestTemplate restTemplate;

    public ConsumerController(IConsumerService consumerService, RestTemplate restTemplate) {
        this.consumerService = consumerService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/add")
    public String add() {
        log.info("loadbalancerConsumer init count 100");
        Consumer consumer = new Consumer();
        consumer.setCount(100);
        consumerService.save(consumer);

        // provider add
        String s = restTemplate.postForObject(PROVIDER_BASE_URL + "/provider/loadbalancer/add/" + consumer.getId(), null, String.class);

        return "loadbalancerConsumer init count 100" + "------>" + s;
    }

    @PostMapping("/another/add")
    public String anotherAdd() {
        log.info("loadbalancerConsumer init count 100");
        Consumer consumer = new Consumer();
        consumer.setCount(100);
        consumerService.save(consumer);

        //another provider add
        String s = restTemplate.postForObject(ANOTHER_PROVIDER_BASE_URL + "/anotherProvider/loadbalancer/add/" + consumer.getId(), null, String.class);

        return "loadbalancerConsumer init count 100" + "------>" + s;
    }
}
