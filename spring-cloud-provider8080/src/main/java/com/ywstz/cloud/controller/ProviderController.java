package com.ywstz.cloud.controller;


import com.ywstz.cloud.entity.Provider;
import com.ywstz.cloud.service.IProviderService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 提供表 前端控制器
 * </p>
 *
 * @author TuoZhou
 * @since 2022-06-22
 */
@RestController
@RequestMapping("/provider")
@Slf4j
public class ProviderController {

    private final IProviderService providerService;

    @Value("${server.port}")
    private String serverPort;

    public ProviderController(IProviderService providerService) {
        this.providerService = providerService;
    }

    //-------------------------------------add-------------------------------------
    @PostMapping("/add/{consumerId}")
    public String add(@PathVariable Long consumerId) {
        log.info("provider add init count 100");
        Provider provider = new Provider();
        provider.setConsumerId(consumerId);
        provider.setCount(100);
        providerService.save(provider);
        return "provider add init count 100 " + "serverPort：" + serverPort;
    }

    @PostMapping("/ribbon/add/{consumerId}")
    public String ribbonAdd(@PathVariable Long consumerId) {
        log.info("provider ribbonAdd init count 100");
        Provider provider = new Provider();
        provider.setConsumerId(consumerId);
        provider.setCount(100);
        providerService.save(provider);
        return "provider ribbonAdd init count 100 " + "serverPort：" + serverPort;
    }

    @PostMapping("/loadbalancer/add/{consumerId}")
    public String loadbalancerAdd(@PathVariable Long consumerId) {
        log.info("provider loadbalancerAdd init count 100");
        Provider provider = new Provider();
        provider.setConsumerId(consumerId);
        provider.setCount(100);
        providerService.save(provider);
        return "provider loadbalancerAdd init count 100 " + "serverPort：" + serverPort;
    }

    @PostMapping("/openfeign/add/{consumerId}")
    public String openfeignAdd(@PathVariable Long consumerId) {
        log.info("provider openfeignAdd init count 100");
        Provider provider = new Provider();
        provider.setConsumerId(consumerId);
        provider.setCount(100);
        providerService.save(provider);
        return "provider openfeignAdd init count 100 " + "serverPort：" + serverPort;
    }


    //-------------------------------------timeout-------------------------------------
    @SneakyThrows(Exception.class)
    @GetMapping("/timeout/{time}")
    public String timeout(@PathVariable Long time) {
        log.info("provider timeout " + time + "s");
        Thread.sleep(time * 1000);
        return "provider timeout " + time + "s " + "serverPort：" + serverPort;
    }

    @SneakyThrows(Exception.class)
    @GetMapping("/ribbon/timeout/{time}")
    public String ribbonTimeout(@PathVariable Long time) {
        log.info("provider ribbonTimeout " + time + "s");
        Thread.sleep(time * 1000);
        return "provider ribbonTimeout " + time + "s " + "serverPort：" + serverPort;
    }

    @SneakyThrows(Exception.class)
    @GetMapping("/loadbalancer/timeout/{time}")
    public String loadbalancerTimeout(@PathVariable Long time) {
        log.info("provider loadbalancerTimeout " + time + "s");
        Thread.sleep(time * 1000);
        return "provider loadbalancerTimeout " + time + "s " + "serverPort：" + serverPort;
    }

    @SneakyThrows(Exception.class)
    @GetMapping("/openfeign/timeout/{time}")
    public String openfeignTimeout(@PathVariable Long time) {
        log.info("provider openfeignTimeout " + time + "s");
        Thread.sleep(time * 1000);
        return "provider openfeignTimeout " + time + "s " + "serverPort：" + serverPort;
    }
}
