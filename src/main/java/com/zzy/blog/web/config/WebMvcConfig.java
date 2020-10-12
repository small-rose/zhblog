package com.zzy.blog.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 登陆拦截控制类
 * Created with IntelliJ IDEA.
 * Author: yangyongkang
 * Date: 2018/8/22
 * Time: 14:17
 */
@Configuration
public class WebMvcConfig implements  WebMvcConfigurer {
    @Autowired
    private UserSecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(securityInterceptor);
       
        // 拦截配置
        addInterceptor.addPathPatterns("/**");
        
        // 排除配置
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/static/**");//排除静态资源
        addInterceptor.excludePathPatterns("/login");
        addInterceptor.excludePathPatterns("/login/check");
        addInterceptor.excludePathPatterns("/logout");
        addInterceptor.excludePathPatterns("/index");
        
        System.out.println(" .......addInterceptors.......");
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/,file:static/");//
    	System.out.println(" .......addResourceHandlers.......");
    }
    
    //设置跨域访问
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
                .allowCredentials(true);//服务端设置可以接收cookie信息
        System.out.println(" .......addCorsMappings.......");
    }
}