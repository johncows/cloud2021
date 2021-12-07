package com.kk.service;

import com.kk.entity.Payment;

public interface PaymentService {
    int add(Payment payment);

    Payment getPaymentDaoById(Long id);
}
