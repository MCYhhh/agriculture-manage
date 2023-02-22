package com.agriculture.controller;


import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.entity.Goods;
import com.agriculture.entity.Scenery;
import com.agriculture.service.IGoodsService;
import com.agriculture.service.ISceneryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private IGoodsService goodsService;

    //根据id查询
    @GetMapping("/{gid}")
    public Result findOne(@PathVariable Integer gid){
        return Result.success(goodsService.getById(gid));
    }

    //根据商品名查询
    @GetMapping("/{gname}")
    public Result findByUname(@PathVariable String gname){
        QueryWrapper<Goods> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("gname",gname);
        return Result.success(goodsService.getOne(queryWrapper));
    }

    //查询所有
    @GetMapping("/findAll")
    public Result listall(){
        return Result.success(goodsService.list());
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Goods goods){
        return Result.success(goodsService.save(goods));
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody Goods goods){
        //iUserService.updateById(user);
        return Result.success(goodsService.updateById(goods));
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Goods goods){
        return Result.success(goodsService.saveOrUpdate(goods));
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer gid){
        goodsService.removeById(gid);
        return Result.success(HttpCode.SUCCESS.code(),HttpCode.SUCCESS.message());
    }


}
