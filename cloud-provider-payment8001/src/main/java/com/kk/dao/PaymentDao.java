package com.kk.dao;

import com.kk.entity.Payment;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

     int add(Payment payment);

     Payment getPaymentDaoById(@Param("id") Long id);
}
