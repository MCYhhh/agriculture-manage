package com.agriculture.controller;


import cn.hutool.core.util.StrUtil;
import com.agriculture.common.HttpCode;
import com.agriculture.controller.dao.UserDao;
import com.agriculture.common.Result;
import com.agriculture.entity.User;
import com.agriculture.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @GetMapping("/findOne/{uid}")
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
        //TY添加
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String upwd= passwordEncoder.encode(user.getUpwd());
        user.setUpwd(upwd);
        return Result.success(iUserService.save(user));
    }

    //修改·
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
    @DeleteMapping("/delete/{uid}")
    public Result delete(@PathVariable Integer uid){
        iUserService.removeById(uid);
        return Result.success(HttpCode.SUCCESS.code(),HttpCode.SUCCESS.message());
    }
    @GetMapping("/hello")
    //spring security自带的
//    @PreAuthorize("hasAuthority('系统管理111')")   //用户有test这个权限才能访问   boolean类型，为true，则有权限（所有的权限用一个字符串表示)
   //自定义权限校验
    @PreAuthorize("@self.hasAuthority('系统管理')")  //在expression包自定义校验方法
    //读取注解中的属性值，之后会将该字符串作为一个表达式进行执行
    public String hello(){
        return "hello";
    }

    //登录
    @PostMapping("/login")
    public Result login(@RequestBody UserDao userDao) {   //@RequestBody 从请求体中获取的数据
        //不需要在登录接口这里判断，登录认证过滤器会进行判断
//        String uaccount =userDao.getUaccount();
//        String upwd = userDao.getUpwd();
//        if (StrUtil.isBlank(uaccount) || StrUtil.isBlank(upwd)) {
//            return Result.error(HttpCode.LOGIN_ERROR.code(), HttpCode.LOGIN_ERROR.message());
//        }
        UserDao dao = iUserService.login(userDao);
        return Result.success("登录成功",dao);
    }

    //注销
    @GetMapping("/logout")
    public Result logout(){
        iUserService.logout();
        return Result.success(HttpCode.SUCCESS.code(),"注销成功");
    }

    //注册
    @PostMapping("/register")
    public Result register(@RequestBody UserDao userDao) {
        String uaccount = userDao.getUaccount();
        String upwd= userDao.getUpwd();
        if (StrUtil.isBlank(uaccount) || StrUtil.isBlank(upwd)) {
            return Result.error(HttpCode.USER_System.code(), "参数错误");
        }
        return Result.success(iUserService.register(userDao));
    }

}
