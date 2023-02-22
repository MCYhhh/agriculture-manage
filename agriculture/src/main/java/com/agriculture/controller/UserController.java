package com.agriculture.controller;


import cn.hutool.core.util.StrUtil;
import com.agriculture.common.HttpCode;
import com.agriculture.controller.dao.UserDao;
import com.agriculture.common.Result;
import com.agriculture.entity.User;
import com.agriculture.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService iUserService;

    //根据id查询
    @GetMapping("/{uid}")
    public Result findOne(@PathVariable Integer uid){
        return Result.success(iUserService.getById(uid));
    }

    //根据用户名查询
    @GetMapping("/{uname}")
    public Result findByUname(@PathVariable String uname){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("uname",uname);
        return Result.success(iUserService.getOne(queryWrapper));
    }

    //查询所有
    @GetMapping("/findAll")
    public Result listall(){
        return Result.success(iUserService.list());
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        return Result.success(iUserService.save(user));
    }

    //修改
    @PostMapping("/modify")
    public Result modify(@RequestBody User user){
        //iUserService.updateById(user);
        return Result.success(iUserService.updateById(user));
    }

    //新增或修改
    @PostMapping("/saveOrmodify")
    public Result saveOrmodify(@RequestBody User user){
        return Result.success(iUserService.saveOrUpdate(user));
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer uid){
        iUserService.removeById(uid);
        return Result.success(HttpCode.SUCCESS.code(),HttpCode.SUCCESS.message());
    }

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody UserDao userDao) {
        String uname =userDao.getUname();
        String upwd = userDao.getUpwd();
        if (StrUtil.isBlank(uname) || StrUtil.isBlank(upwd)) {
            return Result.error(HttpCode.LOGIN_ERROR.code(), HttpCode.LOGIN_ERROR.message());
        }
        UserDao dto = iUserService.login(userDao);
        return Result.success(dto);
    }

}
