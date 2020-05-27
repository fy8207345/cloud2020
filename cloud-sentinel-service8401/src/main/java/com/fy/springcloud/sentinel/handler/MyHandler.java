package com.fy.springcloud.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fy.springcloud.entity.CommonResult;

public class MyHandler {

    public static CommonResult handler(BlockException blockException){
        return new CommonResult(500, "自定义错误处理-1");
    }

    public static CommonResult handler2(BlockException blockException){
        return new CommonResult(500, "自定义错误处理-2");
    }
}
