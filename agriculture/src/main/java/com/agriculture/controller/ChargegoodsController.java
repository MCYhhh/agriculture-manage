package com.agriculture.controller;


import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.ChargegoodsPage;
import com.agriculture.entity.Chargegoods;
import com.agriculture.service.IChargegoodsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品管理表 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@RestController
@RequestMapping("/chargegoods")
public class ChargegoodsController {
    @Autowired
    private IChargegoodsService iChargegoodsService ;
    @GetMapping("/{cid}")
    public Result findOne(@PathVariable Integer cid){
        return Result.success(iChargegoodsService.getById(cid));
    }
    //查询所有
    @GetMapping("/findAll")
    public Result listall(@RequestBody ChargegoodsPage ChargegoodsPage){
        //iUserService.list();
        QueryWrapper<Chargegoods> queryWrapper = new QueryWrapper<>();
        int page=ChargegoodsPage.getPage();
        int size=ChargegoodsPage.getSize();
        Page<Chargegoods> spage = new Page<>(page,size);
        IPage<Chargegoods> ChargegoodsIPage = iChargegoodsService.selectPage(spage, queryWrapper);
        System.out.print("total---"+ChargegoodsIPage.getTotal());
        System.out.print("pages---"+ChargegoodsIPage.getPages());
        System.out.print("record---"+ChargegoodsIPage.getRecords());
        ChargegoodsIPage.getRecords().forEach(System.out::println);
        List row = ChargegoodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无商品需要管理");
        }
        return Result.success(ChargegoodsIPage);
    }

    //按照商品id查询
    @GetMapping("/findGid")
    public Result findGid(@RequestBody ChargegoodsPage ChargegoodsPage){
        QueryWrapper<Chargegoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gid",ChargegoodsPage.getGid());
        int page=ChargegoodsPage.getPage();
        int size=ChargegoodsPage.getSize();
        Page<Chargegoods> spage = new Page<>(page,size);
        IPage<Chargegoods> ChargegoodsIPage = iChargegoodsService.selectPage(spage, queryWrapper);
        System.out.print("total---"+ChargegoodsIPage.getTotal());
        System.out.print("pages---"+ChargegoodsIPage.getPages());
        System.out.print("record---"+ChargegoodsIPage.getRecords());
        ChargegoodsIPage.getRecords().forEach(System.out::println);
        List row = ChargegoodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无商品需要管理");
        }
        return Result.success(ChargegoodsIPage);
    }
    //按照商家id查询
    @GetMapping("/findUid")
    public Result findUid(@RequestBody ChargegoodsPage ChargegoodsPage){
        QueryWrapper<Chargegoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",ChargegoodsPage.getUid());
        int page=ChargegoodsPage.getPage();
        int size=ChargegoodsPage.getSize();
        Page<Chargegoods> spage = new Page<>(page,size);
        IPage<Chargegoods> ChargegoodsIPage = iChargegoodsService.selectPage(spage, queryWrapper);
        System.out.print("total---"+ChargegoodsIPage.getTotal());
        System.out.print("pages---"+ChargegoodsIPage.getPages());
        System.out.print("record---"+ChargegoodsIPage.getRecords());
        ChargegoodsIPage.getRecords().forEach(System.out::println);
        List row = ChargegoodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无商品需要管理");
        }
        return Result.success(ChargegoodsIPage);
    }
    //按照状态查询查询
    @GetMapping("/findState")
    public Result findState(@RequestBody ChargegoodsPage ChargegoodsPage){
        QueryWrapper<Chargegoods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state",ChargegoodsPage.getState());
        int page=ChargegoodsPage.getPage();
        int size=ChargegoodsPage.getSize();
        Page<Chargegoods> spage = new Page<>(page,size);
        IPage<Chargegoods> ChargegoodsIPage = iChargegoodsService.selectPage(spage, queryWrapper);
        System.out.print("total---"+ChargegoodsIPage.getTotal());
        System.out.print("pages---"+ChargegoodsIPage.getPages());
        System.out.print("record---"+ChargegoodsIPage.getRecords());
        ChargegoodsIPage.getRecords().forEach(System.out::println);
        List row = ChargegoodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无商品需要管理");
        }
        return Result.success(ChargegoodsIPage);
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Chargegoods Chargegoods){
        return Result.success(iChargegoodsService.save(Chargegoods));
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody Chargegoods Chargegoods){
        return Result.success(iChargegoodsService.updateById(Chargegoods));
    }
    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Chargegoods Chargegoods){
        return Result.success(iChargegoodsService.saveOrUpdate(Chargegoods));
    }
    //删除
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        iChargegoodsService.removeById(id);
        return Result.success("删除成功");
    }

}
