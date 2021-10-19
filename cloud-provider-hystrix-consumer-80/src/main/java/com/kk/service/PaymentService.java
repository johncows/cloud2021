package com.kk.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: 王骏康
 * @date: 2021/10/18 21:12
 */
@FeignClient("CLOUD-PROVIDER-SERVICE")
public interface PaymentService {

    @GetMapping("success-request")
    String successRequest();

    @GetMapping("timeout-request")
    String timeOutRequest();
}
