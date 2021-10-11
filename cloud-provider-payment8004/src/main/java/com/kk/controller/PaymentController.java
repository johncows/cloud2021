package com.kk.controller;

import com.kk.entity.CommonResult;
import com.kk.entity.Payment;
import com.kk.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payments")
    public CommonResult add( @RequestBody Payment payment){
        int add = paymentService.add(payment);
        log.info("**插入结果**"+add);
        if(add>0){
            return new CommonResult(200,"插入成功");
        }else {
            return new CommonResult(400,"插入失败");
        }
    }

    @GetMapping("/payments/{id}")
    public CommonResult get( @PathVariable Long id){
        Payment payment = paymentService.getPaymentDaoById(id);
        if (payment == null) {
            return new CommonResult(400, "没有对应的记录1");
        }
        return new CommonResult(payment);
    }

}
