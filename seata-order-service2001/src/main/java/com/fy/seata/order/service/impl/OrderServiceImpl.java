package com.fy.seata.order.service.impl;

import com.fy.seata.order.entity.Order;
import com.fy.seata.order.repository.OrderRepository;
import com.fy.seata.order.service.AccountService;
import com.fy.seata.order.service.OrderService;
import com.fy.seata.order.service.StorageService;
import com.fy.springcloud.entity.CommonResult;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    @GlobalTransactional
    @Override
    public Order create(Order order) {
        log.info("开始创建订单");
        orderRepository.save(order);

        log.info("开始扣除库存");
        CommonResult storage = storageService.decrease(order.getProductId(), order.getCount());

        log.info("开始扣除账户余额");
        CommonResult account = accountService.decrease(order.getUserId(), order.getMoney());

        log.info("修改订单状态");
        order.setStatus(1);
        orderRepository.save(order);

        return order;
    }
}
