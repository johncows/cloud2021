package com.kk.service;

import com.kk.dao.PaymentDao;
import com.kk.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int add(Payment payment);

    Payment getPaymentDaoById( Long id);
}
