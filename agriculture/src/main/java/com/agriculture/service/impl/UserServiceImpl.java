package com.agriculture.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.agriculture.config.redis.RedisCache;
import com.agriculture.controller.dao.UserDao;
import com.agriculture.entity.LoginUser;
import com.agriculture.entity.Menu;
import com.agriculture.entity.User;
import com.agriculture.mapper.AdministrateMapper;
import com.agriculture.mapper.RoleMapper;
import com.agriculture.mapper.UserMapper;
import com.agriculture.service.IMenuService;
import com.agriculture.service.IUserService;
import com.agriculture.utils.JwtToken;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author MCY
 * @since 2023-02-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

   @Resource
   private AuthenticationManager authenticationManager;

   @Resource
   private RoleMapper roleMapper;

   @Resource
   private AdministrateMapper administrateMapper;

   @Resource
    IMenuService menuService;

   @Resource
   private RedisCache redisCache;
    @Override
    public UserDao login(UserDao userDao) {
        //通过UsernamePasswordAuthenticationToken获取用户名和密码
        //把用户登录时传入的用户名和密码封装为authentication对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDao.getUaccount(), userDao.getUpwd());

        //AuthenticationManager委托机制对authenticationToken进行用户认证
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        //如果认证没有通过，给出对应的提示
        if (Objects.isNull(authentication)) {
            System.out.println("登录失败");
//            throw new RuntimeException("登录失败");
        }

        //如果认证通过，使用uid生成jwt ，jwt存入userDao返回
        //如果认证通过，拿到这个当前登录用户信息
        LoginUser loginUser= (LoginUser) authentication.getPrincipal();
//
        //获取当前用户的uid
        String uid=loginUser.getUser().getUid().toString();

        String jwt= JwtToken.generateJwt(uid);
        Map<String,String> map=new HashMap<>();
        map.put("token",jwt);
        //        //把完整的用户信息存入redis  uid为key  用户信息为value
        redisCache.setCacheObject("login:"+uid,loginUser);

        //目标对象（target/dest）中包含被copy的对象（source/orig）的所有字段时
        //第一个参数是原对象，第二个参数是需要数据的对象
        BeanUtil.copyProperties(loginUser.getUser(),userDao, true);
//        Integer roleType=loginUser.getUser().getUtype();
//        //设置用户的菜单列表
        List<Menu> roleMenus=loginUser.getMenus();
        userDao.setMenus(roleMenus);
        userDao.setToken(jwt);
        userDao.setUpwd(null);   //将加密后的密码设置为空，再返回给前端
        System.out.println("生成生成jwt");
        System.out.println(jwt);
        System.out.println(loginUser);
        return userDao;
    }

    @Override
    public void logout() {
        //从SecurityContextHolder中获取uid
        UsernamePasswordAuthenticationToken authenticationToken=
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser= (LoginUser) authenticationToken.getPrincipal();
        Integer uid=loginUser.getUser().getUid();

        //根据uid找到redis对应值进行删除
        redisCache.deleteObject("login:"+uid);
    }

//    /**
//     * 获取当前角色的菜单列表
//     * @param roleType
//     * @return
//     */
//    private List<Menu> getRoleMenus(Integer roleType) {
//        Integer roleId = roleMapper.selectByRtype(roleType);
//        // 当前角色的所有菜单id集合
//        List<Integer> menuIds = administrateMapper.selectByRoleId(roleId);
//
//        // 查出系统所有的菜单(树形)
//        List<Menu> menus = menuService.findMenus("");
//        // new一个最后筛选完成之后的list
//        List<Menu> roleMenus = new ArrayList<>();
//        // 筛选当前用户角色的菜单
//        for (Menu menu : menus) {
//            if (menuIds.contains(menu.getMid())) {
//                roleMenus.add(menu);
//            }
//            List<Menu> children = menu.getChildren();
//            // removeIf()  移除 children 里面不在 menuIds集合中的 元素
//            children.removeIf(child -> !menuIds.contains(child.getMid()));
//        }
//        return roleMenus;
//    }

}
