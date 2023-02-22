package com.agriculture.controller;


import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.entity.Scenery;
import com.agriculture.service.ISceneryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 景区表 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@RestController
@RequestMapping("/scenery")
public class SceneryController {
    @Resource
    private ISceneryService sceneryService;

    //根据id查询
    @GetMapping("/{sid}")
    public Result findOne(@PathVariable Integer sid){
        return Result.success(sceneryService.getById(sid));
    }

    //根据景区名查询
    @GetMapping("/{sname}")
    public Result findByUname(@PathVariable String sname){
        QueryWrapper<Scenery> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sname",sname);
        return Result.success(sceneryService.getOne(queryWrapper));
    }

    //查询所有
    @GetMapping("/findAll")
    public Result listall(){
        return Result.success(sceneryService.list());
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Scenery scenery){
        return Result.success(sceneryService.save(scenery));
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody Scenery scenery){
        //iUserService.updateById(user);
        return Result.success(sceneryService.updateById(scenery));
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Scenery scenery){
        return Result.success(sceneryService.saveOrUpdate(scenery));
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer id){
        sceneryService.removeById(id);
        return Result.success(HttpCode.SUCCESS.code(),HttpCode.SUCCESS.message());
    }

}
