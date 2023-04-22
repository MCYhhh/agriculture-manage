package com.agriculture.controller;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.SceneryPage;
import com.agriculture.entity.Scenery;
import com.agriculture.service.ISceneryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 景区表 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@RestController
@RequestMapping("/scenery")
public class SceneryController {
    @Resource
    ISceneryService iSceneryService;

    //插入、保存景点
    @PostMapping("/save")
    public Result save(@RequestBody Scenery scenery){
        for(Scenery a:iSceneryService.list()) {
            if(scenery.getSname().equals(a.getSname())) {
                return Result.error(HttpCode.USER_System.code(),"参数错误，景区已存在");
            }
        }
        return Result.success(iSceneryService.save(scenery));
    }

    //删除景点
    @DeleteMapping("/delete/{sid}")
    public Result delete(@PathVariable("sid") Integer sid){
        System.out.println("sid=="+sid);
        for(Scenery a:iSceneryService.list()) {
            System.out.println(a);
            if(sid.equals(a.getSid())) {
                boolean tmp=iSceneryService.removeById(sid);
                System.out.println(tmp);
                return Result.success(HttpCode.SUCCESS.code(),HttpCode.SUCCESS.message());
            }
        }
        return Result.error(HttpCode.USER_System.code(),"参数错误，景区不存在");
    }

    //通过景点编号sid查询景点
    @PostMapping("/findBySid")
    public Result findBySid(@RequestBody SceneryPage sceneryPage){
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("sid",sceneryPage.getId());
        int page=sceneryPage.getPage();
        int size=sceneryPage.getSize();
        Page<Scenery> spage = new Page<>(page,size);
        IPage<Scenery> sceneryIPage = iSceneryService.selectPage(spage, queryWrapper);
        System.out.print("total---"+sceneryIPage.getTotal());
        System.out.print("pages---"+sceneryIPage.getPages());
        System.out.print("record---"+sceneryIPage.getRecords());
        sceneryIPage.getRecords().forEach(System.out::println);
        List row = sceneryIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的景区");
        }
        return Result.success(sceneryIPage);
    }

    //通过景点名称sname查询景点
    @PostMapping("/findBySname")
    public Result findBySname(@RequestBody SceneryPage sceneryPage){
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("sname",sceneryPage.getName());
        int page=sceneryPage.getPage();
        int size=sceneryPage.getSize();
        Page<Scenery> spage = new Page<>(page,size);
        IPage<Scenery> sceneryIPage = iSceneryService.selectPage(spage, queryWrapper);
        System.out.print("total---"+sceneryIPage.getTotal());
        System.out.print("pages---"+sceneryIPage.getPages());
        System.out.print("record---"+sceneryIPage.getRecords());
        sceneryIPage.getRecords().forEach(System.out::println);
        List row = sceneryIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的景区");
        }
        return Result.success(sceneryIPage);
    }

    //查询所有景点
    @PostMapping("/findAll")
    public Result listall(@RequestBody SceneryPage sceneryPage){
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
//        queryWrapper.isNull("sid");
        int page=sceneryPage.getPage();
        int size=sceneryPage.getSize();
        Page<Scenery> spage = new Page<>(page,size);
        IPage<Scenery> sceneryIPage = iSceneryService.selectPage(spage, queryWrapper);
        System.out.print("total---"+sceneryIPage.getTotal());
        System.out.print("pages---"+sceneryIPage.getPages());
        System.out.print("record---"+sceneryIPage.getRecords());
        sceneryIPage.getRecords().forEach(System.out::println);
        List row = sceneryIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无景区");
        }
        return Result.success(sceneryIPage);
    }

    //筛选大于等于该门票的景点
    @PostMapping("/selectLe")
    public Result selectLe(@RequestBody SceneryPage sceneryPage){
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("sprice",sceneryPage.getPrice());
        int page=sceneryPage.getPage();
        int size=sceneryPage.getSize();
        Page<Scenery> spage = new Page<>(page,size);
        IPage<Scenery> sceneryIPage = iSceneryService.selectPage(spage, queryWrapper);
        System.out.print("total---"+sceneryIPage.getTotal());
        System.out.print("pages---"+sceneryIPage.getPages());
        System.out.print("record---"+sceneryIPage.getRecords());
        sceneryIPage.getRecords().forEach(System.out::println);
        List row = sceneryIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的景区");
        }
        return Result.success(sceneryIPage);
    }

    //筛选小于等于该门票的景点
    @PostMapping("/selectGe")
    public Result selectGe(@RequestBody SceneryPage sceneryPage){
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("sprice",sceneryPage.getPrice());
        int page=sceneryPage.getPage();
        int size=sceneryPage.getSize();
        Page<Scenery> spage = new Page<>(page,size);
        IPage<Scenery> sceneryIPage = iSceneryService.selectPage(spage, queryWrapper);
        System.out.print("total---"+sceneryIPage.getTotal());
        System.out.print("pages---"+sceneryIPage.getPages());
        System.out.print("record---"+sceneryIPage.getRecords());
        sceneryIPage.getRecords().forEach(System.out::println);
        List row = sceneryIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的景区");
        }
        return Result.success(sceneryIPage);
    }

    //通过状态查询sstate，0或1
    @PostMapping("/selectSstate")
    public Result selectSstate(@RequestBody SceneryPage sceneryPage){
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sstate",sceneryPage.getN());
        int page=sceneryPage.getPage();
        int size=sceneryPage.getSize();
        Page<Scenery> spage = new Page<>(page,size);
        IPage<Scenery> sceneryIPage = iSceneryService.selectPage(spage, queryWrapper);
        System.out.print("total---"+sceneryIPage.getTotal());
        System.out.print("pages---"+sceneryIPage.getPages());
        System.out.print("record---"+sceneryIPage.getRecords());
        sceneryIPage.getRecords().forEach(System.out::println);
        List row = sceneryIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            if (sceneryPage.getN()==0){
                return Result.error(HttpCode.USER_System.code(),"参数错误，没有开放的景区");
            }else{
                return Result.error(HttpCode.USER_System.code(),"参数错误，没有关闭的景区");
            }
        }
        return Result.success(sceneryIPage);
    }

    //通过管理员uid查询
    @PostMapping("/selectUid")
    public Result selectUid(@RequestBody SceneryPage sceneryPage){
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",sceneryPage.getUid());
        int page=sceneryPage.getPage();
        int size=sceneryPage.getSize();
        Page<Scenery> spage = new Page<>(page,size);
        IPage<Scenery> sceneryIPage = iSceneryService.selectPage(spage, queryWrapper);
        System.out.print("total---"+sceneryIPage.getTotal());
        System.out.print("pages---"+sceneryIPage.getPages());
        System.out.print("record---"+sceneryIPage.getRecords());
        sceneryIPage.getRecords().forEach(System.out::println);
        List row = sceneryIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的景区");
        }
        return Result.success(sceneryIPage);
    }

    //新增或修改景点
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Scenery scenery){
        return Result.success(iSceneryService.saveOrUpdate(scenery));
    }

    @GetMapping("/test")
    public Result test() {
        int page=1;
        int sizen=2;
        Page<Scenery> spage = new Page<>(page,sizen);
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sstate", 0);
        IPage<Scenery> sceneryIPage = iSceneryService.selectPage(spage, queryWrapper);
        System.out.print("total---"+sceneryIPage.getTotal());
        System.out.print("pages---"+sceneryIPage.getPages());
        System.out.print("record---"+sceneryIPage.getRecords());
        sceneryIPage.getRecords().forEach(System.out::println);
        return Result.success(sceneryIPage);
    }
}
