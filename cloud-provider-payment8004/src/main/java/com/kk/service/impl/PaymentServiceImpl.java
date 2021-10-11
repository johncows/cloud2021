package com.kk.service.impl;

import com.kk.dao.PaymentDao;
import com.kk.entity.Payment;
import com.kk.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentDaoById(Long id) {
        return paymentDao.getPaymentDaoById(id);
    }
}
