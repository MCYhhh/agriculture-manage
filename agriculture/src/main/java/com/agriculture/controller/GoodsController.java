package com.agriculture.controller;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.GoodsPage;
import com.agriculture.entity.Goods;
import com.agriculture.service.IGoodsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    IGoodsService iGoodsService;

    //插入、保存商品
    @PostMapping("/save")
    public Result save(@RequestBody Goods goods){
        for(Goods a:iGoodsService.list()) {
            if(goods.getGname().equals(a.getGname())) {
                return Result.error(HttpCode.USER_System.code(),"参数错误，商品已存在");
            }
        }
        return Result.success(iGoodsService.save(goods));
    }

    //删除商品
    @DeleteMapping("/delete/{gid}")
    public Result delete(@PathVariable("gid") Integer gid){
        System.out.println("sid=="+gid);
        for(Goods a:iGoodsService.list()) {
            System.out.println(a);
            if(gid.equals(a.getGid())) {
                boolean tmp=iGoodsService.removeById(gid);
                System.out.println(tmp);
                return Result.success(HttpCode.SUCCESS.code(),HttpCode.SUCCESS.message());
            }
        }
        return Result.error(HttpCode.USER_System.code(),"参数错误，商品不存在");
    }

    //通过商品编号gid查询商品
    @PostMapping("/findByGid")
    public Result findByGid(@RequestBody GoodsPage goodsPage){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("gid",goodsPage.getGid());
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<Goods> spage = new Page<>(page,size);
        IPage<Goods> goodsIPage = iGoodsService.selectPage(spage, queryWrapper);
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<Goods> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的商品");
        }
        return Result.success(goodsIPage);
    }

    //通过商品名称gname查询商品
    @PostMapping("/findByGname")
    public Result findBySname(@RequestBody GoodsPage goodsPage){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("gname",goodsPage.getGname());
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<Goods> spage = new Page<>(page,size);
        IPage<Goods> goodsIPage = iGoodsService.selectPage(spage, queryWrapper);
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<Goods> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的商品");
        }
        return Result.success(goodsIPage);
    }

    //查询所有商品
    @PostMapping("/findAll")
    public Result listall(@RequestBody GoodsPage goodsPage){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
//        queryWrapper.isNull("gid");
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<Goods> spage = new Page<>(page,size);
        IPage<Goods> goodsIPage = iGoodsService.selectPage(spage, queryWrapper);
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<Goods> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无商品");
        }
        return Result.success(goodsIPage);
    }

    //筛选大于等于该价格的商品
    @PostMapping("/selectLe")
    public Result selectLe(@RequestBody GoodsPage goodsPage){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("gprice",goodsPage.getGprice());
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<Goods> spage = new Page<>(page,size);
        IPage<Goods> goodsIPage = iGoodsService.selectPage(spage, queryWrapper);
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<Goods> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的商品");
        }
        return Result.success(goodsIPage);
    }

    //筛选小于等于该价格的商品
    @PostMapping("/selectGe")
    public Result selectGe(@RequestBody GoodsPage goodsPage){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("gprice",goodsPage.getGprice());
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<Goods> spage = new Page<>(page,size);
        IPage<Goods> goodsIPage = iGoodsService.selectPage(spage, queryWrapper);
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<Goods> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的商品");
        }
        return Result.success(goodsIPage);
    }

    //通过状态查询sstate，0或1或2或3，
    @PostMapping("/selectGsate")
    public Result selectSstate(@RequestBody GoodsPage goodsPage){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gsate",goodsPage.getGsate());
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<Goods> spage = new Page<>(page,size);
        IPage<Goods> goodsIPage = iGoodsService.selectPage(spage,queryWrapper);
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<Goods> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            //（0--未购买，1---购物车中，2----购买待支付，3----已支付）
            if (goodsPage.getGsate()==0){
                return Result.error(HttpCode.USER_System.code(),"参数错误，没有未购买的商品");
            }else if (goodsPage.getGsate()==1){
                return Result.error(HttpCode.USER_System.code(),"参数错误，没有购物车中的商品");
            }else if (goodsPage.getGsate()==2){
                return Result.error(HttpCode.USER_System.code(),"参数错误，没有购买待支付的商品");
            }else if (goodsPage.getGsate()==3){
                return Result.error(HttpCode.USER_System.code(),"参数错误，没有已支付的商品");
            }else{
                return Result.error(HttpCode.USER_System.code(),"参数错误，请修改");
            }
        }
        return Result.success(goodsIPage);
    }

    @PostMapping("/findByGdesp")
    public Result findByGdesp(@RequestBody GoodsPage goodsPage){
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("gdesp",goodsPage.getGdesp());
        int page=goodsPage.getPage();
        int size=goodsPage.getSize();
        Page<Goods> spage = new Page<>(page,size);
        IPage<Goods> goodsIPage = iGoodsService.selectPage(spage, queryWrapper);
        System.out.print("total---"+goodsIPage.getTotal());
        System.out.print("pages---"+goodsIPage.getPages());
        System.out.print("record---"+goodsIPage.getRecords());
        goodsIPage.getRecords().forEach(System.out::println);
        List<Goods> row = goodsIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有该描述的商品");
        }
        return Result.success(goodsIPage);
    }
    
    //新增或修改商品
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Goods goods){
        return Result.success(iGoodsService.saveOrUpdate(goods));
    }
}