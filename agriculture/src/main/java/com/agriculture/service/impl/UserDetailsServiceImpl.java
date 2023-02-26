package com.agriculture.service.impl;

import com.agriculture.entity.LoginUser;
import com.agriculture.entity.Menu;
import com.agriculture.entity.User;
import com.agriculture.mapper.AdministrateMapper;
import com.agriculture.mapper.MenuMapper;
import com.agriculture.mapper.RoleMapper;
import com.agriculture.mapper.UserMapper;
import com.agriculture.service.IMenuService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private AdministrateMapper administrateMapper;

    @Resource
    IMenuService menuService;

    @Override
    public UserDetails loadUserByUsername(String uaccount) throws UsernameNotFoundException {
        //查询用户信息（认证，即校验该用户是否存在）
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<User>();
        queryWrapper.eq(User::getUaccount,uaccount);
        User user=userMapper.selectOne(queryWrapper);
        //如果没有查询到用户，就抛出异常
        if(Objects.isNull(user)){
            throw new RuntimeException("用户账号或者密码错误");
        }
//        查询对应的用户权限信息（授权，即查询用户具有哪些权限）
//        定义一个权限集合

        List<Menu> roleMenus=getRoleMenus(user.getUtype());
//
        //把数据封装成UserDetails返回
        return new LoginUser(user,roleMenus);
    }

    /**
     * 实现UserDeatilsService接口，重写UserDetails方法，自定义用户的信息从数据库中查询
     * */

    private List<Menu> getRoleMenus(Integer roleType) {
        Integer roleId = roleMapper.selectByRtype(roleType);
        // 当前角色的所有菜单id集合
        List<Integer> menuIds = administrateMapper.selectByRoleId(roleId);

        // 查出系统所有的菜单(树形)
        List<Menu> menus = menuService.findMenus("");
        // new一个最后筛选完成之后的list
        List<Menu> roleMenus = new ArrayList<>();
        // 筛选当前用户角色的菜单
        for (Menu menu : menus) {
            if (menuIds.contains(menu.getMid())) {
                roleMenus.add(menu);
            }
            List<Menu> children = menu.getChildren();
            // removeIf()  移除 children 里面不在 menuIds集合中的 元素
            children.removeIf(child -> !menuIds.contains(child.getMid()));
        }
        return roleMenus;
    }
}
