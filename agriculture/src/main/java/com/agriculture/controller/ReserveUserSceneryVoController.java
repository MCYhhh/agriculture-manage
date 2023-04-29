package com.agriculture.controller;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.ReserveUserSceneryVoPage;
import com.agriculture.entity.vo.ReserveUserSceneryVo;
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
@RequestMapping("/reserveUserScenery")
public class ReserveUserSceneryVoController {
    @Resource
    private IReserveService iReserveService;

    @PostMapping("/findAll")
    public Result findAll(@RequestBody ReserveUserSceneryVoPage vPage){
        Page<ReserveUserSceneryVo> iPage = new Page<ReserveUserSceneryVo>(vPage.getPage(),vPage.getSize());

        IPage<ReserveUserSceneryVo> tempIPage=iReserveService.getRUSVo(iPage);
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<ReserveUserSceneryVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有订单");
        }
        return Result.success(tempIPage);
    }

    //    通过sname查询预定订单
    @PostMapping("/findBySname")
    public Result findBySname(@RequestBody ReserveUserSceneryVoPage vPage){
        Page<ReserveUserSceneryVo> iPage = new Page(vPage.getPage(),vPage.getSize());
        IPage<ReserveUserSceneryVo> tempIPage=iReserveService.getRUSVoBySname(iPage,vPage.getSname());
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<ReserveUserSceneryVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的订单");
        }
        return Result.success(tempIPage);
    }

    //    通过uid查询预定订单
    @PostMapping("/findByUname")
    public Result findByUname(@RequestBody ReserveUserSceneryVoPage vPage){
        Page<ReserveUserSceneryVo> iPage = new Page(vPage.getPage(),vPage.getSize());
        IPage<ReserveUserSceneryVo> tempIPage=iReserveService.getRUSVoByUname(iPage,vPage.getUname());
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<ReserveUserSceneryVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的订单");
        }
        return Result.success(tempIPage);
    }
}
