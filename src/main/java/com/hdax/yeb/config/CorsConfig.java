package com.hdax.yeb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration

/**
 * 开启跨域
 */
public class CorsConfig extends WebMvcConfigurationSupport {

    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的域名
        registry.addMapping("/**")
                //设置允许跨域请求的域名   *允许所有的请求域名访问我们的跨域资源
                .allowedOrigins("*")
                //设置 响应头表示是否可以将请求的响应暴露给页面
                .allowCredentials(true)
                //设置允许输入参数的请求方法访问该跨域资源服务器
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                //配置客户端缓存遇见请求的响应时间，默认为1800秒
                .maxAge(3600);
    }
}
