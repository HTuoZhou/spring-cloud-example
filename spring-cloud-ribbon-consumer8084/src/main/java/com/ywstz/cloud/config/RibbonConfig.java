// package com.ywstz.cloud.config;
//
// import com.netflix.loadbalancer.IRule;
// import com.netflix.loadbalancer.RandomRule;
// import com.netflix.loadbalancer.RoundRobinRule;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// /**
//  * @author TuoZhou
//  * 全局生效，针对所有的ribbon客户端
//  */
// @Configuration
// public class RibbonConfig {
//
//     /**
//      * ribbon负载均衡配置
//      */
//     @Bean
//     public IRule iRule() {
//         return new RoundRobinRule();
//     }
//
// }
