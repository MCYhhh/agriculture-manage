package com.agriculture.controller;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.TrolleyPage;
import com.agriculture.entity.Trolley;
import com.agriculture.service.ITrolleyService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/trolley")
public class TrolleyController {
    @Resource
    ITrolleyService iTrolleyService;
//保存购物车
    @PostMapping("/save")
    public Result save(@RequestBody Trolley trolley){
        for(Trolley a:iTrolleyService.list()) {
            if(trolley.getGid().equals(a.getGid())&&trolley.getCid().equals(a.getCid())) {
                a.setTnum(trolley.getTnum()+a.getTnum());
                a.setTtotal(a.getTtotal().add(trolley.getTtotal()));
                return Result.success("修改成功",iTrolleyService.saveOrUpdate(a));
            }
        }
        return Result.success(iTrolleyService.save(trolley));
    }
//tid删除购物车
    @DeleteMapping("/delete/{tid}")
    public Result delete(@PathVariable("tid") Integer tid){
        System.out.println("tid=="+tid);
        for(Trolley a:iTrolleyService.list()) {
            System.out.println(a);
            if(tid == a.getTid()) {
                boolean tmp=iTrolleyService.removeById(tid);
                System.out.println(tmp);
                return Result.success(HttpCode.SUCCESS.code(),HttpCode.SUCCESS.message());
            }
        }
        return Result.error(HttpCode.USER_System.code(),"参数错误，购物车不存在");
    }

//    通过Cid查询购物车，客户查询
    @PostMapping("/findByCid")
    public Result findByCid(@RequestBody TrolleyPage trolleyPage){
        QueryWrapper<Trolley> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("cid",trolleyPage.getCid());
        int page=trolleyPage.getPage();
        int size=trolleyPage.getSize();
        Page<Trolley> spage = new Page<>(page,size);
        IPage<Trolley> trolleyIPage = iTrolleyService.selectPage(spage, queryWrapper);
        System.out.print("total---"+trolleyIPage.getTotal());
        System.out.print("pages---"+trolleyIPage.getPages());
        System.out.print("record---"+trolleyIPage.getRecords());
        trolleyIPage.getRecords().forEach(System.out::println);
        List<Trolley> row = trolleyIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的购物车");
        }
        return Result.success(trolleyIPage);
    }

//    通过商品gid查询,辅助管理员，某一销量
    @PostMapping("/findByGid")
    public Result findByGid(@RequestBody TrolleyPage trolleyPage){
        QueryWrapper<Trolley> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("gid",trolleyPage.getGid());
        int page=trolleyPage.getPage();
        int size=trolleyPage.getSize();
        Page<Trolley> spage = new Page<>(page,size);
        IPage<Trolley> trolleyIPage = iTrolleyService.selectPage(spage, queryWrapper);
        System.out.print("total---"+trolleyIPage.getTotal());
        System.out.print("pages---"+trolleyIPage.getPages());
        System.out.print("record---"+trolleyIPage.getRecords());
        trolleyIPage.getRecords().forEach(System.out::println);
        List<Trolley> row = trolleyIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的购物车");
        }
        return Result.success(trolleyIPage);
    }

//    通过管理员or农户uid查询，自己的产品被加入购物车情况
    @PostMapping("/findByUid")
    public Result findByUid(@RequestBody TrolleyPage trolleyPage){
        QueryWrapper<Trolley> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("uid",trolleyPage.getUid());
        int page=trolleyPage.getPage();
        int size=trolleyPage.getSize();
        Page<Trolley> spage = new Page<>(page,size);
        IPage<Trolley> trolleyIPage = iTrolleyService.selectPage(spage, queryWrapper);
        System.out.print("total---"+trolleyIPage.getTotal());
        System.out.print("pages---"+trolleyIPage.getPages());
        System.out.print("record---"+trolleyIPage.getRecords());
        trolleyIPage.getRecords().forEach(System.out::println);
        List<Trolley> row = trolleyIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的购物车");
        }
        return Result.success(trolleyIPage);
    }
}
