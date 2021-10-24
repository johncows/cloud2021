package com.kk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author wangjunkang
 */
@SpringBootApplication
@EnableHystrixDashboard
public class PaymentMain80 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain80.class, args);
    }

}
