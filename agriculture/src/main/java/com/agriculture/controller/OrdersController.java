package com.agriculture.controller;


import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.OrdersPage;
import com.agriculture.entity.Orders;
import com.agriculture.service.IOrdersService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public Result findOne(@PathVariable Integer oid){
        return Result.success(iOrdersService.getById(oid));
    }
    @GetMapping("/findOstate")
    //根据状态
    public Result findstate(@RequestBody OrdersPage ordersPage){
        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("osate",ordersPage.getOsate());
        int page=ordersPage.getPage();
        int size=ordersPage.getSize();
        Page<Orders> spage = new Page<>(page,size);
        IPage<Orders> ordersIPage = iOrdersService.selectPage(spage, queryWrapper);
        System.out.print("total---"+ordersIPage.getTotal());
        System.out.print("pages---"+ordersIPage.getPages());
        System.out.print("record---"+ordersIPage.getRecords());
        ordersIPage.getRecords().forEach(System.out::println);
        List row = ordersIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无此状态的订单");
        }
        return Result.success(ordersIPage);
    }
    //根据cid
    @GetMapping("/{cid}")
    public Result findcid(@PathVariable Integer cid){

        return Result.success(iOrdersService.findcid(cid));
    }
    //根据uid
    @GetMapping("/{uid}")
    public Result finduid(@PathVariable Integer uid){
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
