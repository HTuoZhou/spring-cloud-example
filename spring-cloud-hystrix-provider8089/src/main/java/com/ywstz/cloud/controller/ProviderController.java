package com.ywstz.cloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.ywstz.cloud.service.IProviderService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 提供表 前端控制器
 * </p>
 *
 * @author TuoZhou
 * @since 2022-06-22
 */
@RestController
@RequestMapping("/hystrixProvider")
@Slf4j
public class ProviderController {

    private final IProviderService providerService;

    @Value("${server.port}")
    private String serverPort;

    public ProviderController(IProviderService providerService) {
        this.providerService = providerService;
    }

    // @HystrixCommand(fallbackMethod = "hystrixOkHandler")
    @GetMapping("/ok")
    public String add() {
        log.info("hystrixProvider ok");

        // int i = 10 / 0;

        return "hystrixProvider ok " + "serverPort：" + serverPort;
    }

    //-------------------------------------timeout-------------------------------------
    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @SneakyThrows(Exception.class)
    @GetMapping("/timeout/{time}")
    public String timeout(@PathVariable Long time) {
        log.info("hystrixProvider timeout " + time + "s");
        Thread.sleep(time * 1000);
        return "hystrixProvider timeout " + time + "s " + "serverPort：" + serverPort;
    }

    // public String hystrixOkHandler() {
    //     return "hystrixOkHandler";
    // }

    public String hystrixTimeoutHandler(Long time) {
        return "hystrixTimeoutHandler";
    }

}
