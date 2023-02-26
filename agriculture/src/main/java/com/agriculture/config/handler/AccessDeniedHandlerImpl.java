package com.agriculture.config.handler;

import com.agriculture.common.HttpCode;
import com.agriculture.common.Result;
import com.agriculture.utils.WebUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result result=new Result(HttpCode.USER_NOAUTHON.code(),"用户权限不足",null);
        String json= JSON.toJSONString(result);
        //处理异常
        WebUtils.renderString(response,json);
    }
}
