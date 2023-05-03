package com.agriculture.controller;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.config.mybatis.ArticlePage;
import com.agriculture.entity.Article;
import com.agriculture.service.IArticleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private IArticleService iArticleService ;
    //根据id
    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id){
        return Result.success(iArticleService.getById(id));
    }

    //查询所有
    @PostMapping("/findAll")
    public Result listall(@RequestBody ArticlePage articlePage){
        //iUserService.list();
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        int page=articlePage.getPage();
        int size=articlePage.getSize();
        Page<Article> spage = new Page<>(page,size);
        IPage<Article> articleIPage = iArticleService.selectPage(spage, queryWrapper);
        System.out.print("total---"+articleIPage.getTotal());
        System.out.print("pages---"+articleIPage.getPages());
        System.out.print("record---"+articleIPage.getRecords());
        articleIPage.getRecords().forEach(System.out::println);
        List row = articleIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无文章");
        }
        return Result.success(articleIPage);
    }
  //通过文章名查找
    @GetMapping("/findTitle")
    public Result findTitle(@RequestBody ArticlePage articlePage){
        //iUserService.list();
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title",articlePage.getTitle());
        int page=articlePage.getPage();
        int size=articlePage.getSize();
        Page<Article> spage = new Page<>(page,size);
        IPage<Article> articleIPage = iArticleService.selectPage(spage, queryWrapper);
        System.out.print("total---"+articleIPage.getTotal());
        System.out.print("pages---"+articleIPage.getPages());
        System.out.print("record---"+articleIPage.getRecords());
        articleIPage.getRecords().forEach(System.out::println);
        List row = articleIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无以该名字命名的文章");
        }
        return Result.success(articleIPage);
    }
    //通过作者id查找
    @GetMapping("/findUid")
    public Result findUid(@RequestBody ArticlePage articlePage){
        //iUserService.list();
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid",articlePage.getUid());
        int page=articlePage.getPage();
        int size=articlePage.getSize();
        Page<Article> spage = new Page<>(page,size);
        IPage<Article> articleIPage = iArticleService.selectPage(spage, queryWrapper);
        System.out.print("total---"+articleIPage.getTotal());
        System.out.print("pages---"+articleIPage.getPages());
        System.out.print("record---"+articleIPage.getRecords());
        articleIPage.getRecords().forEach(System.out::println);
        List row = articleIPage.getRecords();
        //判断查询结果是否为空
        if(row== null || row.size() ==0){
            return Result.error(HttpCode.USER_System.code(),"暂无此作者的文章");
        }
        return Result.success(articleIPage);
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Article article){
        return Result.success(iArticleService.save(article));
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody Article article){
        return Result.success(iArticleService.updateById(article));
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody Article article){
        return Result.success(iArticleService.saveOrUpdate(article));
    }

    //删除
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id){
        iArticleService.removeById(id);
        return Result.success("删除成功");
    }


}
