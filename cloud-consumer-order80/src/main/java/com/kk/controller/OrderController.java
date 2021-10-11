package com.kk.controller;


import com.kk.entity.CommonResult;
import com.kk.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASEURL = "http://CLOUD-PAYMENT-SERVICE/";


    @PostMapping("/payments")
    public CommonResult add(@RequestBody Payment payment) {
        return restTemplate.postForEntity(BASEURL + "payments", payment, CommonResult.class).getBody();
    }

    @GetMapping("/payments/{id}")
    public CommonResult get(@PathVariable Long id) {
        return restTemplate.getForEntity(BASEURL + "payments/" + id, CommonResult.class).getBody();
    }

}
