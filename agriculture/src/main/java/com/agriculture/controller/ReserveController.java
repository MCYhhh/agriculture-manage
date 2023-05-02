package com.agriculture.controller;


import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.ReservePage;
import com.agriculture.entity.Reserve;
import com.agriculture.service.IReserveService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 景区预约 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@RestController
@RequestMapping("/reserve")
public class ReserveController {
    @Autowired
    private IReserveService iReserveService ;
    //根据id
    @GetMapping("/{rid}")
    public Result findOne(@PathVariable Integer rid){
        return Result.success(iReserveService.getById(rid));
    }
    //查询所有
    @GetMapping("/findAll")
    public Result listall(@RequestBody ReservePage ReservePage){
        //iUserService.list();
        QueryWrapper<Reserve> queryWrapper = new QueryWrapper<>();
        int page=ReservePage.getPage();
        int size=ReservePage.getSize();
        Page<Reserve> spage = new Page<>(page,size);
        IPage<Reserve> IPage = iReserveService.selectPage(spage, queryWrapper);
        System.out.print("total---"+IPage.getTotal());
        System.out.print("pages---"+IPage.getPages());
        System.out.print("record---"+IPage.getRecords());
        IPage.getRecords().forEach(System.out::println);
        List row = IPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无预定");
        }
        return Result.success(IPage);
    }
    //通过景区id查找
    @GetMapping("/findSid")
    public Result findSid(@RequestBody ReservePage ReservePage){
        //iUserService.list();
        QueryWrapper<Reserve> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", ReservePage.getSid());
        int page=ReservePage.getPage();
        int size=ReservePage.getSize();
        Page<Reserve> spage = new Page<>(page,size);
        IPage<Reserve> IPage = iReserveService.selectPage(spage, queryWrapper);
        System.out.print("total---"+IPage.getTotal());
        System.out.print("pages---"+IPage.getPages());
        System.out.print("record---"+IPage.getRecords());
        IPage.getRecords().forEach(System.out::println);
        List row = IPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"此景点暂无预约");
        }
        return Result.success(IPage);
    }
    //通过用户id查找
    @GetMapping("/findUid")
    public Result findUid(@RequestBody ReservePage ReservePage){
        //iUserService.list();
        QueryWrapper<Reserve> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", ReservePage.getUid());
        int page=ReservePage.getPage();
        int size=ReservePage.getSize();
        Page<Reserve> spage = new Page<>(page,size);
        IPage<Reserve> IPage = iReserveService.selectPage(spage, queryWrapper);
        System.out.print("total---"+IPage.getTotal());
        System.out.print("pages---"+IPage.getPages());
        System.out.print("record---"+IPage.getRecords());
        IPage.getRecords().forEach(System.out::println);
        List row = IPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"此用户暂无预约");
        }
        return Result.success(IPage);
    }
//    @GetMapping("/findGid")
//    public Result findGid(@RequestBody ReservePage ReservePage){
//        //iUserService.list();
//        QueryWrapper<Reserve> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("gid", ReservePage.getGid());
//        int page=ReservePage.getPage();
//        int size=ReservePage.getSize();
//        Page<Reserve> spage = new Page<>(page,size);
//        IPage<Reserve> IPage = iReserveService.selectPage(spage, queryWrapper);
//        System.out.print("total---"+IPage.getTotal());
//        System.out.print("pages---"+IPage.getPages());
//        System.out.print("record---"+IPage.getRecords());
//        IPage.getRecords().forEach(System.out::println);
//        List row = IPage.getRecords();
//        //判断查询结果是否为空
//        if(row== null || row.size() ==0){
//            return Result.error(HttpCode.USER_System.code(),"此用户暂无预约");
//        }
//        return Result.success(IPage);
//    }
    //人数大于等于某个数
    @GetMapping("/findLe")
    public Result findLe(@RequestBody ReservePage ReservePage){
        //iUserService.list();
        QueryWrapper<Reserve> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("dnum", ReservePage.getDnum());
        int page=ReservePage.getPage();
        int size=ReservePage.getSize();
        Page<Reserve> spage = new Page<>(page,size);
        IPage<Reserve> IPage = iReserveService.selectPage(spage, queryWrapper);
        System.out.print("total---"+IPage.getTotal());
        System.out.print("pages---"+IPage.getPages());
        System.out.print("record---"+IPage.getRecords());
        IPage.getRecords().forEach(System.out::println);
        List row = IPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"此用户暂无预约");
        }
        return Result.success(IPage);
    }
    //人数小于等于某个数
    @GetMapping("/findGe")
    public Result findGe(@RequestBody ReservePage ReservePage){
        //iUserService.list();
        QueryWrapper<Reserve> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("dnum", ReservePage.getDnum());
        int page=ReservePage.getPage();
        int size=ReservePage.getSize();
        Page<Reserve> spage = new Page<>(page,size);
        IPage<Reserve> IPage = iReserveService.selectPage(spage, queryWrapper);
        System.out.print("total---"+IPage.getTotal());
        System.out.print("pages---"+IPage.getPages());
        System.out.print("record---"+IPage.getRecords());
        IPage.getRecords().forEach(System.out::println);
        List row = IPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"此用户暂无预约");
        }
        return Result.success(IPage);
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Reserve Reserve){
        return Result.success(iReserveService.save(Reserve));
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody Reserve Reserve){
        return Result.success(iReserveService.updateById(Reserve));
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Reserve Reserve){
        return Result.success(iReserveService.saveOrUpdate(Reserve));
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        iReserveService.removeById(id);
        return Result.success("删除成功");
    }
}