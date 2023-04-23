package com.agriculture.controller;

import com.agriculture.common.Result;
import com.agriculture.config.mybatis.OrderUserVOPage;
import com.agriculture.entity.vo.OrderUserVO;
import com.agriculture.service.IOrderUserVOService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/orderuservo")
public class OrderUserVOController {
    @Resource
    IOrderUserVOService service;
    @PostMapping("/myorders")
    public Result myorders(@RequestBody OrderUserVOPage  OrderUserVOPage){
        Page<OrderUserVO> iPage = new Page<OrderUserVO>( OrderUserVOPage.getPage(), OrderUserVOPage.getSize());
        Integer cid=OrderUserVOPage.getCid();
        return Result.success(service.myorders(iPage,cid));
    }
    @PostMapping("/bmyorders")
    public Result bmyorders(@RequestBody OrderUserVOPage  OrderUserVOPage){
        Page<OrderUserVO> iPage = new Page<OrderUserVO>( OrderUserVOPage.getPage(), OrderUserVOPage.getSize());
        Integer uid=OrderUserVOPage.getUid();
        return Result.success(service.bmyorders(iPage,uid));
    }
    @PostMapping("/allorders")
    public Result allorders(@RequestBody OrderUserVOPage  OrderUserVOPage){
        Page<OrderUserVO> iPage = new Page<OrderUserVO>( OrderUserVOPage.getPage(), OrderUserVOPage.getSize());
        Integer uid=OrderUserVOPage.getUid();
        Integer cid=OrderUserVOPage.getCid();
        return Result.success(service.allorders(iPage));
    }
    @PostMapping("/ciduidorders")
    public Result ciduidorders(@RequestBody OrderUserVOPage  OrderUserVOPage){
        Page<OrderUserVO> iPage = new Page<OrderUserVO>( OrderUserVOPage.getPage(), OrderUserVOPage.getSize());
        Integer uid=OrderUserVOPage.getUid();
        Integer cid=OrderUserVOPage.getCid();
        return Result.success(service.ciduidorders(iPage,uid,cid));
    }



}
