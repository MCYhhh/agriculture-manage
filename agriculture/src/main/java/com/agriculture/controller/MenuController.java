package com.agriculture.controller;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.MenuPage;
import com.agriculture.entity.Menu;
import com.agriculture.service.IMenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-25
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    IMenuService iMenuService;

    @PostMapping("/save")
    public Result save(@RequestBody Menu menu){
        for(Menu a:iMenuService.list()) {
            if(menu.getMtitle().equals(a.getMtitle())) {
                return Result.error(HttpCode.USER_System.code(),"参数错误，菜单已存在");
            }
        }
        return Result.success(iMenuService.save(menu));
    }
    @DeleteMapping("/delete/{mid}")
    public Result delete(@PathVariable("mid") Integer mid){
        System.out.println("mid=="+mid);
        for(Menu a:iMenuService.list()) {
            System.out.println(a);
            if(mid.equals(a.getMid())) {
                boolean tmp=iMenuService.removeById(mid);
                System.out.println(tmp);
                return Result.success(HttpCode.SUCCESS.code(),HttpCode.SUCCESS.message());
            }
        }
        return Result.error(HttpCode.USER_System.code(),"参数错误，菜单不存在");
    }

    //通过菜单编号mid查询菜单
    @PostMapping("/findByMid")
    public Result findByMid(@RequestBody MenuPage menuPage){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("mid",menuPage.getMid());
        int page=menuPage.getPage();
        int size=menuPage.getSize();
        Page<Menu> spage = new Page<>(page,size);
        IPage<Menu> menuIPage = iMenuService.selectPage(spage, queryWrapper);
        System.out.print("total---"+menuIPage.getTotal());
        System.out.print("pages---"+menuIPage.getPages());
        System.out.print("record---"+menuIPage.getRecords());
        menuIPage.getRecords().forEach(System.out::println);
        List<Menu> row = menuIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的菜单");
        }
        return Result.success(menuIPage);
    }

    //通过菜单名称sname查询菜单
    @PostMapping("/findByMtitle")
    public Result findByMtitle(@RequestBody MenuPage menuPage){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("mtitle",menuPage.getMtitle());
        int page=menuPage.getPage();
        int size=menuPage.getSize();
        Page<Menu> spage = new Page<>(page,size);
        IPage<Menu> menuIPage = iMenuService.selectPage(spage, queryWrapper);
        System.out.print("total---"+menuIPage.getTotal());
        System.out.print("pages---"+menuIPage.getPages());
        System.out.print("record---"+menuIPage.getRecords());
        menuIPage.getRecords().forEach(System.out::println);
        List<Menu> row = menuIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的菜单");
        }
        return Result.success(menuIPage);
    }

    //查询所有菜单
    @PostMapping("/findAll")
    public Result listall(@RequestBody MenuPage menuPage){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
//        queryWrapper.isNull("mid");
        int page=menuPage.getPage();
        int size=menuPage.getSize();
        Page<Menu> spage = new Page<>(page,size);
        IPage<Menu> menuIPage = iMenuService.selectPage(spage, queryWrapper);
        System.out.print("total---"+menuIPage.getTotal());
        System.out.print("pages---"+menuIPage.getPages());
        System.out.print("record---"+menuIPage.getRecords());
        menuIPage.getRecords().forEach(System.out::println);
        List<Menu> row = menuIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无菜单");
        }
        return Result.success(menuIPage);
    }


    //通过显示状态查询state，0或1
    @PostMapping("/selectState")
    public Result selectSstate(@RequestBody MenuPage menuPage){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state",menuPage.getState());
        int page=menuPage.getPage();
        int size=menuPage.getSize();
        Page<Menu> spage = new Page<>(page,size);
        IPage<Menu> menuIPage = iMenuService.selectPage(spage, queryWrapper);
        System.out.print("total---"+menuIPage.getTotal());
        System.out.print("pages---"+menuIPage.getPages());
        System.out.print("record---"+menuIPage.getRecords());
        menuIPage.getRecords().forEach(System.out::println);
        List<Menu> row = menuIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            if (menuPage.getState()==0){
                return Result.error(HttpCode.USER_System.code(),"参数错误，没有正常的菜单");
            }else if(menuPage.getState()==1){
                return Result.error(HttpCode.USER_System.code(),"参数错误，没有停用的菜单");
            }else{
                return Result.error(HttpCode.USER_System.code(),"参数错误，请修改");
            }
        }
        return Result.success(menuIPage);
    }

    @PostMapping("/selectMvisible")
    public Result selectMvisible(@RequestBody MenuPage menuPage){
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mvisible",menuPage.getMvisible());
        int page=menuPage.getPage();
        int size=menuPage.getSize();
        Page<Menu> spage = new Page<>(page,size);
        IPage<Menu> menuIPage = iMenuService.selectPage(spage, queryWrapper);
        System.out.print("total---"+menuIPage.getTotal());
        System.out.print("pages---"+menuIPage.getPages());
        System.out.print("record---"+menuIPage.getRecords());
        menuIPage.getRecords().forEach(System.out::println);
        List<Menu> row = menuIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            if (menuPage.getMvisible()==0){
                return Result.error(HttpCode.USER_System.code(),"参数错误，没有显示的菜单");
            }else if(menuPage.getMvisible()==1){
                return Result.error(HttpCode.USER_System.code(),"参数错误，没有隐藏的菜单");
            }else{
                return Result.error(HttpCode.USER_System.code(),"参数错误，请修改");
            }
        }
        return Result.success(menuIPage);
    }

    //新增或修改菜单
    @PostMapping("/saveOrModify")
    public Result saveOrmodify(@RequestBody Menu menu){
        return Result.success(iMenuService.saveOrUpdate(menu));
    }
}
