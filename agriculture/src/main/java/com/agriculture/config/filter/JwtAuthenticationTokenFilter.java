package com.agriculture.config.filter;

import com.agriculture.config.redis.RedisCache;
import com.agriculture.entity.LoginUser;
import com.agriculture.utils.JwtToken;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Objects;

/**
 * 过滤器 JWT过滤认证
 * */

//OncePerRequestFilter:保证一个请求只会经过这个过滤器一次
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Resource
    private RedisCache redisCache;

    /**
     * 自定义一个过滤器
     * 这个过滤器会去获取请求头中的token，对token进行解析取出其中的uid
     * 使用uid去redis中获取对应的LoginUser对象
     * 然后封装Authentication对象存入SecurityContextHolder
     * */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token=request.getHeader("token");
        if(!StringUtils.hasText(token)){   //如果token为空
            //放行
            filterChain.doFilter(request,response);
            return;   //加上return，没有token，就不会继续进行解析
        }
        //解析token
        String uid;
        try{
            Claims claims= JwtToken.parseJwt(token);
            uid=claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }

        //从redis中获取用户信息
        String redisKey="login:"+uid;
        LoginUser loginUser=redisCache.getCacheObject(redisKey);
        if(Objects.isNull(loginUser)){
            throw new RemoteException("用户未登录");
        }

        //封装Authentication对象存入SecurityContextHolder
        //获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request,response);
    }
}
