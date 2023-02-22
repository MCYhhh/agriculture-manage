package com.agriculture.controller;


import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.entity.Reserve;
import com.agriculture.entity.Scenery;
import com.agriculture.entity.User;
import com.agriculture.service.IReserveService;
import com.agriculture.service.ISceneryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 景区预约 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@RestController
@RequestMapping("/reserve")
public class ReserveController {
    @Resource
    private IReserveService reserveService;

    //根据id查询
    @GetMapping("/{rid}")
    public Result findOne(@PathVariable Integer rid){
        return Result.success(reserveService.getById(rid));
    }


    //查询所有
    @GetMapping("/findAll")
    public Result listall(){
        return Result.success(reserveService.list());
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Reserve reserve){
        return Result.success(reserveService.save(reserve));
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody Reserve reserve){
        //iUserService.updateById(user);
        return Result.success(reserveService.updateById(reserve));
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Reserve reserve){
        return Result.success(reserveService.saveOrUpdate(reserve));
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer id){
        reserveService.removeById(id);
        return Result.success(HttpCode.SUCCESS.code(),HttpCode.SUCCESS.message());
    }


}
