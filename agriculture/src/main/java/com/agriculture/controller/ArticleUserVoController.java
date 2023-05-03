package com.agriculture.controller;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.ArticleUserVoPage;
import com.agriculture.entity.vo.ArticleUserVo;
import com.agriculture.service.IArticleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@RestController
@RequestMapping("/articleUser")
public class ArticleUserVoController {
    @Resource
    private IArticleService iService;

    //    查询所有文章用户
    @PostMapping("/findAll")
    public Result findAll(@RequestBody ArticleUserVoPage aPage){
        Page<ArticleUserVo> iPage = new Page(aPage.getPage(),aPage.getSize());
        IPage<ArticleUserVo> tempIPage=iService.getAll(iPage);
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<ArticleUserVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有文章");
        }
        return Result.success(tempIPage);
    }

    //    通过用户编号查询文章
    @PostMapping("/findByUid")
    public Result findByUid(@RequestBody ArticleUserVoPage aPage){
        Page<ArticleUserVo> iPage = new Page(aPage.getPage(),aPage.getSize());
        IPage<ArticleUserVo> tempIPage=iService.getByUid(iPage,aPage.getUid());
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<ArticleUserVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的文章");
        }
        return Result.success(tempIPage);
    }
    @PostMapping("/findByAid")
    public Result findByAid(@RequestBody ArticleUserVoPage aPage){
        Page<ArticleUserVo> iPage = new Page(aPage.getPage(),aPage.getSize());
        IPage<ArticleUserVo> tempIPage=iService.getByAid(iPage,aPage.getId());
        System.out.print("total---"+tempIPage.getTotal());
        System.out.print("pages---"+tempIPage.getPages());
        System.out.print("record---"+tempIPage.getRecords());
        tempIPage.getRecords().forEach(System.out::println);
        List<ArticleUserVo> row = tempIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"参数错误，没有符合条件的文章");
        }
        return Result.success(tempIPage);
    }
}
