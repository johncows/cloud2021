package com.kk.controller;



import com.kk.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("success-request")
    public String successRequest(){
       return paymentService.successRequest();
    }

    @GetMapping("timeout-request")
    public String timeOutRequest(){
        return paymentService.timeOutRequest();
    }

}
