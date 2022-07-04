package com.ywstz.cloud.controller;

import com.ywstz.cloud.service.IProviderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TuoZhou
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    private final IProviderService providerService;

    public ProviderController(IProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping(value = "/sendMessage")
    public String sendMessage() {
        return providerService.sendMessage();
    }
}
