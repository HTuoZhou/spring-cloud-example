package com.ywstz.cloud.controller;


import com.ywstz.cloud.entity.Consumer;
import com.ywstz.cloud.service.IConsumerService;
import lombok.extern.slf4j.Slf4j;
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

    public static final String PROVIDER_BASE_URL = "http://localhost:8080/spring-cloud-provider/";
    private final IConsumerService consumerService;
    private final RestTemplate restTemplate;

    public ConsumerController(IConsumerService consumerService,RestTemplate restTemplate) {
        this.consumerService = consumerService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/add")
    public String add() {
        log.info("consumer count init 100");
        Consumer consumer = new Consumer();
        consumer.setCount(100);
        consumerService.save(consumer);

        // provider add
        restTemplate.postForObject(PROVIDER_BASE_URL + "/provider/add/" + consumer.getId(),null,String.class);

        return "consumer count init 100";
    }

    @PostMapping("/reduce/{id}")
    public String reduce(@PathVariable Long id) {
        log.info("consumer count reduce ");
        Consumer consumer = consumerService.getById(id);
        consumer.setCount(consumer.getCount() - 1);
        consumerService.updateById(consumer);

        // provider reduce
        restTemplate.postForObject(PROVIDER_BASE_URL + "/provider/reduce/" + id,null,String.class);

        return "consumer count reduce 1";
    }

}
