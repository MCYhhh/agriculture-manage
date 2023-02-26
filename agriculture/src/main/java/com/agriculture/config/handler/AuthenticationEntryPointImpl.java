package com.agriculture.config.handler;


import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.utils.WebUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component   //放到spring容器中
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    /**
     * 认证的异常处理类
     * */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
       //HttpStatus----spring提供的枚举类（HttpStatus.UNAUTHORIZED.value)
        Result result=new Result(HttpCode.LOGIN_ERROR.code(),"用户认证失败，请重新登录!",null);
        String json= JSON.toJSONString(result);
        //处理异常
        WebUtils.renderString(response,json);
    }
}
