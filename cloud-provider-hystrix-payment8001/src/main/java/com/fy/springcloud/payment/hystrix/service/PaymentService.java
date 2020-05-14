package com.fy.springcloud.payment.hystrix.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String paymentInfo_OK(Long id){
        return "线程池：" + id + ", " + Thread.currentThread().getName();
    }

    public String paymentInfo_Timeout(Long id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + id + ", " + Thread.currentThread().getName() + ", 耗时三秒";
    }
}
