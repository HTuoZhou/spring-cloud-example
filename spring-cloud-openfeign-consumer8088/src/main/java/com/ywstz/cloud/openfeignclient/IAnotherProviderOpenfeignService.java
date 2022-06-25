package com.ywstz.cloud.openfeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author TuoZhou
 */
@FeignClient(name = "SPRING-CLOUD-ANOTHER-PROVIDER-SERVICE", path = "/spring-cloud-another-provider")
// 局部配置，使用特定的openfeign配置
// @FeignClient(name = "SPRING-CLOUD-ANOTHER-PROVIDER-SERVICE",path = "/spring-cloud-another-provider",configuration = OpenfeignAnotherProviderConfig.class)
public interface IAnotherProviderOpenfeignService {

    @PostMapping("/anotherProvider/openfeign/add/{consumerId}")
    public String add(@PathVariable Long consumerId);

}
