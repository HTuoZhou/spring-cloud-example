// package com.ywstz.config;
//
// import feign.Contract;
// import feign.Logger;
// import feign.Request;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// import java.util.concurrent.TimeUnit;
//
// /**
//  * @author TuoZhou
//  */
// @Configuration
// public class OpenfeignProviderConfig {
//
//     /**
//      * openfeign日志配置
//      */
//     @Bean
//     public Logger.Level level() {
//         return Logger.Level.FULL;
//     }
//
//     // /**
//     //  * 契约配置，支持原生的注解
//     //  */
//     // @Bean
//     // public Contract contract() {
//     //     return new Contract.Default();
//     // }
//
//     /**
//      * 连接、请求处理超时配置
//      */
//     @Bean
//     public Request.Options options() {
//         return new Request.Options(10, TimeUnit.SECONDS,60,TimeUnit.SECONDS,false);
//     }
//
// }
