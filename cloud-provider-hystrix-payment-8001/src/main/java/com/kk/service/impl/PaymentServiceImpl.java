package com.kk.service.impl;

import com.kk.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * @author: 王骏康
 * @date: 2021/10/18 21:13
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String successRequest() {
        return "success request";
    }

    @Override
    public String timeOutRequest() {
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "fail request,error Thread "+ Thread.currentThread().getName();
    }
}
