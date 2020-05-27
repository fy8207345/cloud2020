package com.fy.seata.account.controller;

import com.fy.seata.account.repository.AccountRepository;
import com.fy.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("count") BigDecimal count){
        log.info("账户开始扣款");
        accountRepository.updateStorage(userId, count);
        log.info("账户扣款成功");
        return new CommonResult(200, "account decrease success");
    }
}
