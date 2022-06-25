package com.ywstz.cloud.openfeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author TuoZhou
 */
@FeignClient(name = "SPRING-CLOUD-PROVIDER-SERVICE", path = "/spring-cloud-provider")
// 局部配置，使用特定的openfeign配置
// @FeignClient(name = "SPRING-CLOUD-PROVIDER-SERVICE",path = "/spring-cloud-provider",configuration = OpenfeignProviderConfig.class)
public interface IProviderOpenfeignService {

    @PostMapping("/provider/openfeign/add/{consumerId}")
    public String openfeignAdd(@PathVariable Long consumerId);

    @GetMapping("/provider/openfeign/timeout/{time}")
    public String openfeignTimeout(@PathVariable Long time);

}
