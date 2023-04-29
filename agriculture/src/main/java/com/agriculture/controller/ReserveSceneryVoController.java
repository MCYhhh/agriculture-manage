package com.agriculture.controller;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.ReserveSceneryPage;
import com.agriculture.entity.vo.ReserveSceneryVo;
import com.agriculture.service.IReserveService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/reserveScenery")
public class ReserveSceneryVoController {
    @Resource
    private IReserveService iReserveService;

    //    查询所有预定详情
    @PostMapping("/findAll")
    public Result findAll(@RequestBody ReserveSceneryPage reserveSceneryVo){
        Page<ReserveSceneryVo> iPage = new Page<ReserveSceneryVo>(reserveSceneryVo.getPage(),reserveSceneryVo.getSize());

        IPage<ReserveSceneryVo> tempIPage=iReserveService.getReserveSceneryPageVo(iPage);
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<ReserveSceneryVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有订单");
        }
        return Result.success(tempIPage);
    }

    //    通过用户id查询预定景区
    @PostMapping("/findByCid")
    public Result findByCid(@RequestBody ReserveSceneryPage reserveSceneryPage){
        Page<ReserveSceneryVo> iPage = new Page(reserveSceneryPage.getPage(),reserveSceneryPage.getSize());
        IPage<ReserveSceneryVo> tempIPage=iReserveService.getReserveSceneryPageVoByCid(iPage,reserveSceneryPage.getCid());
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<ReserveSceneryVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的订单");
        }
        return Result.success(tempIPage);
    }

    //    通过商家id查询预定景区
    @PostMapping("/findByUid")
    public Result findByUid(@RequestBody ReserveSceneryPage reserveSceneryPage){
        Page<ReserveSceneryVo> iPage = new Page(reserveSceneryPage.getPage(),reserveSceneryPage.getSize());
        IPage<ReserveSceneryVo> tempIPage=iReserveService.getReserveSceneryPageVoByUid(iPage,reserveSceneryPage.getUid());
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<ReserveSceneryVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的订单");
        }
        return Result.success(tempIPage);
    }
}