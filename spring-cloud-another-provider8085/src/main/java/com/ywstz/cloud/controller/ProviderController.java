package com.ywstz.cloud.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ywstz.cloud.entity.Provider;
import com.ywstz.cloud.service.IProviderService;
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

    @PostMapping("/add/{consumerId}")
    public String add(@PathVariable Long consumerId) {
        log.info("another provider count init 100");
        Provider provider = new Provider();
        provider.setConsumerId(consumerId);
        provider.setCount(100);
        providerService.save(provider);
        return "another provider count init 100 " + "serverPort：" + serverPort;
    }

    @PostMapping ("/reduce/{consumerId}")
    public String reduce(@PathVariable Long consumerId) {
        log.info("another provider count reduce ");
        Provider provider = providerService.getOne(Wrappers.<Provider>lambdaQuery()
                .eq(Provider::getConsumerId,consumerId));
        provider.setCount(provider.getCount() - 1);
        providerService.updateById(provider);
        return "another provider count reduce 1 " + "serverPort：" + serverPort;
    }

}
