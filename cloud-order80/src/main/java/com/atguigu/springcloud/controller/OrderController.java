package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.common.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001";

    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL +"", payment, CommonResult.class);
    }
}
