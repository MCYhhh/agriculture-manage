package com.agriculture.controller;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.entity.Scenery;
import com.agriculture.service.ISceneryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
    @GetMapping("/findBySid/{sid}")
    public Result findBySid(@PathVariable("sid") Integer sid){
        return Result.success(iSceneryService.getById(sid));
    }

    //通过景点名称sname查询景点
    @GetMapping("/findBySname/{sname}")
    public Result findBySname(@PathVariable("sname") String sname){
        QueryWrapper<Scenery> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sname",sname);
        return Result.success(iSceneryService.getOne(queryWrapper));
    }

    //查询所有景点
    @GetMapping("/findAll")
    public Result listall(){
        return Result.success(iSceneryService.list());
    }

    //筛选大于等于该门票的景点
    @GetMapping("/selectLe/{sprice}")
    public List<Scenery> selectLe(@PathVariable("sprice") BigDecimal sprice){
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("sprice",sprice);
        return iSceneryService.selectList(queryWrapper);
    }

    //筛选小于等于该门票的景点
    @GetMapping("/selectGe/{sprice}")
    public List<Scenery>selectGe(@PathVariable("sprice") BigDecimal sprice){
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("sprice",sprice);
        return iSceneryService.selectList(queryWrapper);
    }

    //通过状态查询sstate，0或1
    @GetMapping("/selectSstate/{n}")
    public List<Scenery>selectSstate(@PathVariable("n") int n){
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sstate",n);
        return iSceneryService.selectList(queryWrapper);
    }

    //通过管理员uid查询
    @GetMapping("/selectUid/{n}")
    public List<Scenery>selectUid(@PathVariable("n") int n){
        QueryWrapper<Scenery> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",n);
        return iSceneryService.selectList(queryWrapper);
    }

    //新增或修改景点
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Scenery scenery){
        return Result.success(iSceneryService.saveOrUpdate(scenery));
    }
}