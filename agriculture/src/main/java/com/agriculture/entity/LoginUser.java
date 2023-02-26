package com.agriculture.entity;

import com.agriculture.mapper.MenuMapper;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {
    /**
     * 封装用户相关信息
     * */
    private User user;

//    存放当前登录用户的权限信息，一个用户可以有多个权限
    @Resource
    private List<Menu> menus;


    public LoginUser(User user, List<Menu> menuList){
        this.user=user;
        this.menus=menuList;
    }

    //    权限集合
    @JSONField(serialize = false)  //不需要序列化到redis中（不需要把authorities这个成员变量存入redis中，存入permissions即可）
    private List<SimpleGrantedAuthority> authorities;

    //获取权限信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

//
//        /**
//         * 把permissons中的String类型的权限信息封装成SimpleGrantedAuthority对象
//         * */
////        第一种方式
//        List<GrantedAuthority> newList=new ArrayList<>();
//////        for(String i:permissions){
//////            SimpleGrantedAuthority authority=new SimpleGrantedAuthority(permissions);
//////            newList.add(authority);
//////        }
////
////        第二种方式
//        newList=permissions.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//
//        return newList;

        if(authorities!=null){
            return authorities;
        }
        List<String> peimissions=new ArrayList<>();
        for(Menu i:menus){
            peimissions.add(i.getMtitle());
        }
        authorities=peimissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getUpwd();
    }

    @Override
    public String getUsername() {
        return user.getUaccount();
    }

//    是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

//    是否未锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

//    凭证是否未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

//    是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }



}
