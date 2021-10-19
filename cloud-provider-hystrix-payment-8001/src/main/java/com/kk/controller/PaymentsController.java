package com.kk.controller;



import com.kk.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("success-request")
    public String successRequest(){
       return paymentService.successRequest();
    }

    @GetMapping("timeout_request")
    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {

    }
    )
    public String timeOutRequest(){
        return paymentService.timeOutRequest();
    }

    public String timeoutHandler(){
        return "wait too much time";
    }

}
