package com.atguigu.springcloud.services;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entites.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int Create(Payment model) {
        return paymentDao.Create(model);
    }

    @Override
    public int Update(long id, Payment model) {
        return paymentDao.Update(id, model.getCount(), model.getPrice(), model.getName());
    }

    @Override
    public int Delete(long id) {
        return paymentDao.Delete(id);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public List<Payment> getList() {
        return paymentDao.getPayments();
    }


}
