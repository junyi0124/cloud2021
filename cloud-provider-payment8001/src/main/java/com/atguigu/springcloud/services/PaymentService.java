package com.atguigu.springcloud.services;


import com.atguigu.springcloud.entities.Payment;

import java.util.List;

public interface PaymentService {

    int Create(Payment model);

    int Update(long id, Payment model);

    int Delete(long id);

    Payment getPaymentById(long id);

    List<Payment> getList();
}
