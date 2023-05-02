package com.agriculture.config.security;

//import com.agriculture.config.filter.JwtAuthenticationTokenFilter;
import com.agriculture.config.filter.JwtAuthenticationTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;


//@Configuration   //定义为配置类
@EnableGlobalMethodSecurity(prePostEnabled = true)   //开启授权注解功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private AccessDeniedHandler accessDeniedHandler;

    /**
     * 默认使用的PasswordEncoder要求数据库中的密码格式为: {id}password,根据id去判断密码加密方式
     * 一般不采用这种方法，需要替换PasswordEncoder
     * 创建BCryptPasswordEncoder注入容器
     * */
    @Bean  //注入容器中
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    /**
     * 通过AuthencationManager的authenticate方法进行用户认证，
     * 需要在SecurityConfig配置中把AuthenticationManager注入容器
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
              //关闭csrf
              .csrf().disable()
              //不通过Session获取SecurityContext(默认情况下是从Session中获取SecurityContext）
              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and()
              .authorizeRequests()
              //对于登录接口  允许匿名访问（未登录状态下也可以访问，登录状态下不可以）
                //permitAll 表示登录状态下和未登录状态下都可以访问
              .antMatchers("/user/login","/user/register").anonymous()
                .antMatchers("/file/**").permitAll()
              //除上面外的所有请求全部需要鉴权认证
              .anyRequest().authenticated();
//      把token校验过滤器添加到过滤器中
//      addFilterBefore:把某个过滤器添加到某个过滤器之前（通过字节码对象来指定）
//      UsernamePasswordAuthenticationFilter.class---字节码
      http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

      //配置异常处理器
        http.exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)  //认证失败处理器
                .accessDeniedHandler(accessDeniedHandler);

        //允许跨域
        http.cors();
    }



    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
