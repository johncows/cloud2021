package com.kk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wangjunkang
 */
@SpringBootApplication
// 该注解由于向consul或者 zookeeper注册中心时注册服务
@EnableDiscoveryClient
public class PaymentMain8005 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8005.class, args);
    }

}
