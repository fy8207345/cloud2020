package com.fy.springcloud.order.nacos.feign.fallback;

import com.fy.springcloud.entity.CommonResult;
import com.fy.springcloud.entity.Payment;
import com.fy.springcloud.order.nacos.feign.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFallbackImpl implements PaymentService {
    @Override
    public CommonResult<Payment> get(Long id) {
        return new CommonResult<>(666, "服务降级PaymentServiceFallbackImpl： " + id);
    }
}
