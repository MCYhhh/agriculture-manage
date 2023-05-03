package com.agriculture.controller;

import com.agriculture.common.Result;
import com.agriculture.config.mybatis.ChargeGoodsVOPage;
import com.agriculture.entity.vo.ChargeGoodsVO;
import com.agriculture.service.IChargeGoodsVOService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/chargegoodsvo")
public class ChargeGoodsVOController {
    @Resource
    IChargeGoodsVOService service;
    @PostMapping("/all")
    public Result  all(@RequestBody ChargeGoodsVOPage ChargeGoodsVOPage){
        Page<ChargeGoodsVO> iPage = new Page<ChargeGoodsVO>(ChargeGoodsVOPage.getPage(),ChargeGoodsVOPage.getSize());
        return Result.success(service.all(iPage));
    }

    @PostMapping("/mygoods")
    public Result mygoods(@RequestBody ChargeGoodsVOPage ChargeGoodsVOPage){
        Page<ChargeGoodsVO> iPage = new Page<ChargeGoodsVO>(ChargeGoodsVOPage.getPage(),ChargeGoodsVOPage.getSize());
        Integer uid=ChargeGoodsVOPage.getUid();
        return Result.success(service.getChargeGoodsVOPage(iPage,uid));
    }
    @PostMapping("/findgid")
    public Result findgid(@RequestBody ChargeGoodsVOPage ChargeGoodsVOPage){
        Page<ChargeGoodsVO> iPage = new Page<ChargeGoodsVO>(ChargeGoodsVOPage.getPage(),ChargeGoodsVOPage.getSize());
        Integer gid=ChargeGoodsVOPage.getGid();
        return Result.success(service.findGid(iPage,gid));
    }
    @PostMapping("/findgname")
    public Result findgname(@RequestBody ChargeGoodsVOPage ChargeGoodsVOPage){
        Page<ChargeGoodsVO> iPage = new Page<ChargeGoodsVO>(ChargeGoodsVOPage.getPage(),ChargeGoodsVOPage.getSize());
        String gname=ChargeGoodsVOPage.getGname();
        return Result.success(service.findgname(iPage,gname));
    }
    @PostMapping("/finduidgname")
    public Result finduidgname(@RequestBody ChargeGoodsVOPage ChargeGoodsVOPage){
        Page<ChargeGoodsVO> iPage = new Page<ChargeGoodsVO>(ChargeGoodsVOPage.getPage(),ChargeGoodsVOPage.getSize());
        String gname=ChargeGoodsVOPage.getGname();
        Integer uid=ChargeGoodsVOPage.getUid();
        return Result.success(service.finduidgname(iPage,gname,uid));
    }







}
