package com.ywstz.cloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ywstz.cloud.openfeignclient.IProviderOpenfeignService;
import com.ywstz.cloud.service.IConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 消费表 前端控制器
 * </p>
 *
 * @author TuoZhou
 * @since 2022-06-22
 */
@RestController
@RequestMapping("/hystrixConsumer")
@Slf4j
public class ConsumerController {

    private final IConsumerService consumerService;
    private final DiscoveryClient discoveryClient;
    private final IProviderOpenfeignService providerOpenfeignService;

    public ConsumerController(IConsumerService consumerService, DiscoveryClient discoveryClient, IProviderOpenfeignService providerOpenfeignService) {
        this.consumerService = consumerService;
        this.discoveryClient = discoveryClient;
        this.providerOpenfeignService = providerOpenfeignService;
    }

    @GetMapping("/ok")
    public String ok() {
        log.info("hystrixConsumer ok");

        // hystrixProvider ok
        String s = providerOpenfeignService.ok();

        return "hystrixConsumer ok" + "------>" + s;
    }

    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping("/timeout/{time}")
    public String timeout(@PathVariable Long time) {
        log.info("hystrixConsumer timeout " + time + "s");

        // hystrixProvider timeout
        String s = providerOpenfeignService.timeout(time);

        return "hystrixConsumer timeout " + time + "s" + "------>" + s;
    }

    public String hystrixTimeoutHandler(Long time) {
        return "hystrixTimeoutHandler";
    }
}
