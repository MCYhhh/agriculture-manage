package com.agriculture.controller;


import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.DetailorderPage;
import com.agriculture.entity.Detailorder;
import com.agriculture.service.IDetailorderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单商品表 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@RestController
@RequestMapping("/detailorder")
public class DetailorderController {
    @Autowired
    private IDetailorderService iDetailorderService ;
    @GetMapping("/{did}")
    public Result findOne(@PathVariable Integer did){
        return Result.success(iDetailorderService.getById(did));
    }

    //查询所有
    @GetMapping("/findAll")
    public Result listall(@RequestBody DetailorderPage detailOrderpage){
        //iUserService.list();
        QueryWrapper<Detailorder> queryWrapper = new QueryWrapper<>();
        int page=detailOrderpage.getPage();
        int size=detailOrderpage.getSize();
        Page<Detailorder> spage = new Page<>(page,size);
        IPage<Detailorder> detailOrderIpage = iDetailorderService.selectPage(spage, queryWrapper);
        System.out.print("total---"+detailOrderIpage.getTotal());
        System.out.print("pages---"+detailOrderIpage.getPages());
        System.out.print("record---"+detailOrderIpage.getRecords());
        detailOrderIpage.getRecords().forEach(System.out::println);
        List row = detailOrderIpage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无订单详情");
        }
        return Result.success(detailOrderIpage);
    }
    //通过商品号
    @GetMapping("/findGid")
    public Result findGid(@RequestBody DetailorderPage detailOrderpage){
        QueryWrapper<Detailorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gid",detailOrderpage.getGid());
        int page=detailOrderpage.getPage();
        int size=detailOrderpage.getSize();
        Page<Detailorder> spage = new Page<>(page,size);
        IPage<Detailorder> detailOrderIpage = iDetailorderService.selectPage(spage, queryWrapper);
        System.out.print("total---"+detailOrderIpage.getTotal());
        System.out.print("pages---"+detailOrderIpage.getPages());
        System.out.print("record---"+detailOrderIpage.getRecords());
        detailOrderIpage.getRecords().forEach(System.out::println);
        List row = detailOrderIpage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无关于该商品的订单");
        }
        return Result.success(detailOrderIpage);
    }
    @GetMapping("/findOid")
    public Result findOid(@RequestBody DetailorderPage detailOrderpage){
        QueryWrapper<Detailorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("oid",detailOrderpage.getOid());
        int page=detailOrderpage.getPage();
        int size=detailOrderpage.getSize();
        Page<Detailorder> spage = new Page<>(page,size);
        IPage<Detailorder> detailOrderIpage = iDetailorderService.selectPage(spage, queryWrapper);
        System.out.print("total---"+detailOrderIpage.getTotal());
        System.out.print("pages---"+detailOrderIpage.getPages());
        System.out.print("record---"+detailOrderIpage.getRecords());
        detailOrderIpage.getRecords().forEach(System.out::println);
        List row = detailOrderIpage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无关于此订单号的订单");
        }
        return Result.success(detailOrderIpage);
    }
    //搜索>=某价格的订单详情
    @GetMapping("/findLe")
    public Result findLe(@RequestBody DetailorderPage detailOrderpage){
        QueryWrapper<Detailorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("dtotal",detailOrderpage.getDtotal());
        int page=detailOrderpage.getPage();
        int size=detailOrderpage.getSize();
        Page<Detailorder> spage = new Page<>(page,size);
        IPage<Detailorder> detailOrderIpage = iDetailorderService.selectPage(spage, queryWrapper);
        System.out.print("total---"+detailOrderIpage.getTotal());
        System.out.print("pages---"+detailOrderIpage.getPages());
        System.out.print("record---"+detailOrderIpage.getRecords());
        detailOrderIpage.getRecords().forEach(System.out::println);
        List row = detailOrderIpage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无关于此订单号的订单");
        }
        return Result.success(detailOrderIpage);
    }
    //搜索<=某价格的订单详情
    @GetMapping("/findGe")
    public Result findGe(@RequestBody DetailorderPage detailOrderpage){
        QueryWrapper<Detailorder> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("dtotal",detailOrderpage.getDtotal());
        int page=detailOrderpage.getPage();
        int size=detailOrderpage.getSize();
        Page<Detailorder> spage = new Page<>(page,size);
        IPage<Detailorder> detailOrderIpage = iDetailorderService.selectPage(spage, queryWrapper);
        System.out.print("total---"+detailOrderIpage.getTotal());
        System.out.print("pages---"+detailOrderIpage.getPages());
        System.out.print("record---"+detailOrderIpage.getRecords());
        detailOrderIpage.getRecords().forEach(System.out::println);
        List row = detailOrderIpage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无关于此订单号的订单");
        }
        return Result.success(detailOrderIpage);
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Detailorder Detailorder){
        return Result.success(iDetailorderService.save(Detailorder));
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody Detailorder Detailorder){
        return Result.success(iDetailorderService.updateById(Detailorder));
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Detailorder Detailorder){
        return Result.success(iDetailorderService.saveOrUpdate(Detailorder));
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        iDetailorderService.removeById(id);
        return Result.success("删除成功");
    }

}
