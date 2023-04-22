package com.agriculture.controller;


import com.agriculture.common.Result;
import com.agriculture.entity.Orders;
import com.agriculture.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService ;
    //根据oid
    @GetMapping("/{oid}")
    public Result findOne(Integer oid){
        return Result.success(iOrdersService.getById(oid));
    }
    @GetMapping("/{ostate}")
    //根据状态
    public Result findstate(Integer ostate){
        return Result.success(iOrdersService.findstate(ostate));
    }
    //根据cid
    @GetMapping("/{cid}")
    public Result findcid(Integer cid){

        return Result.success(iOrdersService.findcid(cid));
    }
    //根据uid
    @GetMapping("/{uid}")
    public Result finduid(Integer uid){
        return Result.success(iOrdersService.finduid(uid));
    }

    //查询所有
    @GetMapping("/findAll")
    public Result listall(){
        //iUserService.list();
        return Result.success(iOrdersService.list());
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Orders order){
//        iOrderService.save(order);
        return Result.success(iOrdersService.save(order));
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody Orders order){
        return Result.success(iOrdersService.updateById(order));
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Orders order){
        return Result.success(iOrdersService.saveOrUpdate(order));
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer oid){
        iOrdersService.removeById(oid);
        return Result.success("删除成功");
    }
    //模糊查询（顾客名）
    @PostMapping("/blurcname")
    public Result blurcname(String cname) {
        return Result.success(iOrdersService.blurcname(cname));
    }
    //模糊查询（商家名）
    @PostMapping("/bluruname")
    public Result bluruname(String uname) {
        return  Result.success(iOrdersService.bluruname(uname));
    }
    //按照价格查询(>=传进来的数)
    @PostMapping("/ototal")
    public Result findtotal(BigDecimal ototal) {
        return  Result.success(iOrdersService.findototal(ototal));
    }


}
