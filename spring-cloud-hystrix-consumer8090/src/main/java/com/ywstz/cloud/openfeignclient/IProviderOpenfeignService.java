package com.ywstz.cloud.openfeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author TuoZhou
 */
@FeignClient(name = "SPRING-CLOUD-HYSTRIX-PROVIDER-SERVICE", path = "/spring-cloud-hystrix-provider")
public interface IProviderOpenfeignService {

    @GetMapping("/hystrixProvider/ok")
    public String ok();

    @GetMapping("/hystrixProvider/timeout/{time}")
    public String timeout(@PathVariable Long time);

}
