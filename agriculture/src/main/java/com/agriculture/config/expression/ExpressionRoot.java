package com.agriculture.config.expression;

import com.agriculture.entity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component("self")
public class ExpressionRoot {
    /**
     * 自自定义权限校验
     * */
    public boolean hasAuthority(String authority){
        //获取当前用户的权限
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser= (LoginUser) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> permissions=loginUser.getAuthorities();
        //判断用户权限集合中是否存在authority
        return permissions.contains(authority);
    }
}
