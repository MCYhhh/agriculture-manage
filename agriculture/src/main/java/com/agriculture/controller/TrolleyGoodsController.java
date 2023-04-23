package com.agriculture.controller;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.TrolleyGoodsPage;
import com.agriculture.entity.vo.TrolleyGoodsVo;
import com.agriculture.service.ITrolleyService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/trolleyGoods")
public class TrolleyGoodsController {
    @Resource
    private ITrolleyService iTrolleyService;

//    查询所有购物车向前
    @PostMapping("/findAll")
    public Result findAll(@RequestBody TrolleyGoodsPage trolleyGoodsPage){
        Page<TrolleyGoodsVo> iPage = new Page<TrolleyGoodsVo>(trolleyGoodsPage.getPage(),trolleyGoodsPage.getSize());

        IPage<TrolleyGoodsVo> tempIPage=iTrolleyService.getTrolleyGoodsPageVo(iPage);
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<TrolleyGoodsVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有订单");
        }
        return Result.success(tempIPage);
    }

//    通过用户编号查询购物车详情
    @PostMapping("/findByCid")
    public Result findByCid(@RequestBody TrolleyGoodsPage trolleyGoodsPage){
        Page<TrolleyGoodsVo> iPage = new Page(trolleyGoodsPage.getPage(),trolleyGoodsPage.getSize());
        IPage<TrolleyGoodsVo> tempIPage=iTrolleyService.getTrolleyGoodsPageVoByCid(iPage,trolleyGoodsPage.getCid());
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<TrolleyGoodsVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的订单");
        }
        return Result.success(tempIPage);
    }

    //    通过商家编号查询购物车详情
    @PostMapping("/findByUid")
    public Result findByUid(@RequestBody TrolleyGoodsPage trolleyGoodsPage){
        Page<TrolleyGoodsVo> iPage = new Page(trolleyGoodsPage.getPage(),trolleyGoodsPage.getSize());
        IPage<TrolleyGoodsVo> tempIPage=iTrolleyService.getTrolleyGoodsPageVoByUid(iPage,trolleyGoodsPage.getUid());
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<TrolleyGoodsVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的订单");
        }
        return Result.success(tempIPage);
    }
}