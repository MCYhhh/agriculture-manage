package com.agriculture.controller;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.GoodsPage;
import com.agriculture.config.mybatis.OrderUserVOPage;
import com.agriculture.entity.Goods;
import com.agriculture.entity.vo.OrderUserVO;
import com.agriculture.service.IOrderUserVOService;
import com.agriculture.service.IOrdersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/orderuservo")
public class OrderUserVOController {
    @Resource
    IOrderUserVOService service;
    @Resource
    IOrdersService iOrdersService;
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

    @PostMapping("/orderUserLe")
    public Result orderLe(@RequestBody OrderUserVOPage goodsPage){
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<OrderUserVO> spage = new Page<>(page,size);
        IPage<OrderUserVO> goodsIPage = iOrdersService.orderUserLePage(spage, goodsPage.getOtotal());
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<OrderUserVO> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的订单");
        }
        return Result.success(goodsIPage);
    }

    @PostMapping("/orderUserGe")
    public Result orderGe(@RequestBody OrderUserVOPage goodsPage){
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<OrderUserVO> spage = new Page<>(page,size);
        IPage<OrderUserVO> goodsIPage = iOrdersService.orderUserGePage(spage, goodsPage.getOtotal());
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<OrderUserVO> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的订单");
        }
        return Result.success(goodsIPage);
    }

    @PostMapping("/orderUserUame")
    public Result orderUame(@RequestBody OrderUserVOPage goodsPage){
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<OrderUserVO> spage = new Page<>(page,size);
        IPage<OrderUserVO> goodsIPage = iOrdersService.orderUserUamePage(spage,goodsPage.getUname());
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<OrderUserVO> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的订单");
        }
        return Result.success(goodsIPage);
    }

    @PostMapping("/orderUserOsate")
    public Result orderUserOsate(@RequestBody OrderUserVOPage goodsPage){
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<OrderUserVO> spage = new Page<>(page,size);
        IPage<OrderUserVO> goodsIPage = iOrdersService.orderUserOsatePage(spage,goodsPage.getOsate());
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<OrderUserVO> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的订单");
        }
        return Result.success(goodsIPage);
    }

    @PostMapping("/orderUserOid")
    public Result orderUserOid(@RequestBody OrderUserVOPage goodsPage){
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<OrderUserVO> spage = new Page<>(page,size);
        IPage<OrderUserVO> goodsIPage = iOrdersService.orderUserOidPage(spage, goodsPage.getOid());
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<OrderUserVO> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的订单");
        }
        return Result.success(goodsIPage);
    }


}
