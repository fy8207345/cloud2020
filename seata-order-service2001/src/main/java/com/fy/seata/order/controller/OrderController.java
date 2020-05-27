package com.fy.seata.order.controller;

import com.fy.seata.order.entity.Order;
import com.fy.seata.order.service.OrderService;
import com.fy.springcloud.entity.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        Order order1 = orderService.create(order);
        return new CommonResult(200, "创建成功", order1);
    }
}
