package com.fy.seata.storage.controller;

import com.fy.seata.storage.repository.StorageRepository;
import com.fy.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StorageController {

    @Autowired
    private StorageRepository storageRepository;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        log.info("开始扣除库存");
        storageRepository.updateStorage(productId, count);
        log.info("扣除库存成功");
        return new CommonResult(200, "storage decrease success");
    }
}
