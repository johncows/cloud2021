package com.kk.controller;



import com.kk.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    @GetMapping("timeout-request")
//    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {
//        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    }
//    )
    public String timeOutRequest(){
        return paymentService.timeOutRequest();
    }

    public String timeoutHandler(Integer id){
        return "异常服务 单号"+id;
    }

    @GetMapping("order/{id}")
    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"), // 开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), // 该周期内受访的次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),// 10秒内一个周期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败60跳闸
    })
    public String getOrder(@PathVariable Integer  id){
        if(id%2==1){
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "正常服务 单号"+id;
    }

}
