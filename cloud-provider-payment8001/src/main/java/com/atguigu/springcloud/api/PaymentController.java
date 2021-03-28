package com.atguigu.springcloud.api;

import com.atguigu.springcloud.entites.Payment;
import com.atguigu.springcloud.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.atguigu.springcloud.common.CommonResult;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
@Slf4j
public class PaymentController {

    @Autowired
    public PaymentController(PaymentService paymentService) {
        _paymentService = paymentService;
    }

    private PaymentService _paymentService;

    @GetMapping()
    public CommonResult<List<Payment>> getList() {
        List<Payment> payment = _paymentService.getList();
        if(payment == null) {
            return new CommonResult(404, "payment 没有找到");
        }
        else if(payment.isEmpty()) {
            return new CommonResult<List<Payment>>(200,"成功", payment);
        }
        else {
            return new CommonResult<List<Payment>>(200,"成功",payment);
        }
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") long id ) {
        Payment payment = _paymentService.getPaymentById(id);
        if(payment == null) {
            return new CommonResult(404, "payment 没有找到");
        }
        else{
            return new CommonResult<Payment>(200, "成功", payment);
        }
    }


    @PostMapping()
    public CommonResult<Payment> post(@RequestBody Payment model) {
        int code = _paymentService.Create(model);
        log.info("code is " + code);
        log.warn("code is " + code);
        log.error("code is " + model.getId());
        return new CommonResult<>(204, "success");
    }

    @PutMapping("/{id}")
    public CommonResult<Payment> put(@PathVariable("id") long id, @RequestBody Payment model) {
        int code = _paymentService.Update(id, model);
        log.info("code is " + code);
        if(code>0) {
            Payment entity = _paymentService.getPaymentById(id);
            return new CommonResult<Payment>(200, "success", entity);
        }
        return new CommonResult<>(200, "success");
    }
}
