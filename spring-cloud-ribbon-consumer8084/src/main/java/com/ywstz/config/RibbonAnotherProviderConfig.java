package com.ywstz.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author TuoZhou
 */
@Configuration
public class RibbonAnotherProviderConfig {

    /**
     * ribbon负载均衡配置
     */
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }

}
