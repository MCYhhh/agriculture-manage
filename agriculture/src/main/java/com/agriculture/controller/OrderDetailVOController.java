package com.agriculture.controller;

import com.agriculture.common.Result;
import com.agriculture.service.IOrderDetailVOService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orderdetailvo")
public class OrderDetailVOController {
    @Resource
    IOrderDetailVOService service;
    @GetMapping("/myorder/{oid}")
    public Result myorder(@PathVariable("oid") Integer oid){
        if(service.myorder(oid)!=null)
           return Result.success(service.myorder(oid));
        else
            return Result.success("暂无此订单详情");
    }

}
