package com.agriculture.config.cors;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Value("${file.path}")
    private String filepath;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域请求的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                //设置允许cookie
                .allowCredentials(true)
                //设置允许的请求方式
                .allowedMethods("GET","POST","DELETE","PUT")
                //设置允许的header属性
                .allowedHeaders("*")
                //跨域运行时间
                .maxAge(3600);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将图片访问路径映射到D盘
        registry.addResourceHandler("/file/**").addResourceLocations("file:"+filepath);
//以下的写法表示将“/img/img/img/**”映射到项目里面resource.static.img,这只是个示例，相信你能够理解
//        registry.addResourceHandler("/img/img/img/**").addResourceLocations("classpath:/static/img/**");
    }
}

