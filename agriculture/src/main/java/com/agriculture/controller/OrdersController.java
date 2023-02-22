package com.agriculture.controller;


import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.entity.Orders;
import com.agriculture.entity.Scenery;
import com.agriculture.service.IOrdersService;
import com.agriculture.service.ISceneryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Resource
    private IOrdersService ordersService;

    //根据id查询
    @GetMapping("/{oid}")
    public Result findOne(@PathVariable Integer oid){
        return Result.success(ordersService.getById(oid));
    }

    //根据景区名查询
    @GetMapping("/{oname}")
    public Result findByUname(@PathVariable String oname){
        QueryWrapper<Orders> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("oname",oname);
        return Result.success(ordersService.getOne(queryWrapper));
    }

    //查询所有
    @GetMapping("/findAll")
    public Result listall(){
        return Result.success(ordersService.list());
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Orders orders){
        return Result.success(ordersService.save(orders));
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody Orders orders){
        return Result.success(ordersService.updateById(orders));
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Orders orders){
        return Result.success(ordersService.saveOrUpdate(orders));
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer id){
        ordersService.removeById(id);
        return Result.success(HttpCode.SUCCESS.code(),HttpCode.SUCCESS.message());
    }

}
