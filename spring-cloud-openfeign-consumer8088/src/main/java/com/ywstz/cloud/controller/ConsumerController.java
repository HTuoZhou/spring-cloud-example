package com.ywstz.cloud.controller;


import com.ywstz.cloud.entity.Consumer;
import com.ywstz.cloud.openfeignclient.IAnotherProviderOpenfeignService;
import com.ywstz.cloud.openfeignclient.IProviderOpenfeignService;
import com.ywstz.cloud.service.IConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 消费表 前端控制器
 * </p>
 *
 * @author TuoZhou
 * @since 2022-06-22
 */
@RestController
@RequestMapping("/openfeignConsumer")
@Slf4j
public class ConsumerController {
    private final IConsumerService consumerService;
    private final IProviderOpenfeignService providerOpenfeignService;
    private final IAnotherProviderOpenfeignService anotherProviderOpenfeignService;

    public ConsumerController(IConsumerService consumerService, IProviderOpenfeignService providerOpenfeignService, IAnotherProviderOpenfeignService anotherProviderOpenfeignService) {
        this.consumerService = consumerService;
        this.providerOpenfeignService = providerOpenfeignService;
        this.anotherProviderOpenfeignService = anotherProviderOpenfeignService;
    }

    @PostMapping("/add")
    public String add() {
        log.info("openfeignConsumer init count 100");
        Consumer consumer = new Consumer();
        consumer.setCount(100);
        consumerService.save(consumer);

        // provider add
        String s = providerOpenfeignService.openfeignAdd(consumer.getId());

        return "openfeignConsumer init count 100" + "------>" + s;
    }

    @PostMapping("/another/add")
    public String anotherAdd() {
        log.info("openfeignConsumer init count 100");
        Consumer consumer = new Consumer();
        consumer.setCount(100);
        consumerService.save(consumer);

        //another provider add
        String s = anotherProviderOpenfeignService.openfeignAdd(consumer.getId());

        return "openfeignConsumer init count 100" + "------>" + s;
    }

    @GetMapping("/timeout/{time}")
    public String timeout(@PathVariable Long time) {
        log.info("openfeignConsumer timeout " + time + "s");

        // provider timeout
        String s = providerOpenfeignService.openfeignTimeout(time);

        return "openfeignConsumer timeout " + time + "s" + "------>" + s;
    }

    @GetMapping("/another/timeout/{time}")
    public String anotherTimeout(@PathVariable Long time) {
        log.info("openfeignConsumer timeout " + time + "s");

        // another provider timeout
        String s = anotherProviderOpenfeignService.openfeignTimeout(time);

        return "openfeignConsumer timeout " + time + "s" + "------>" + s;
    }

}
