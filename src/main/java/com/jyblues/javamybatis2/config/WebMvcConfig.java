package com.jyblues.javamybatis2.config;

import com.jyblues.javamybatis2.controller.authorization.JwtInterceptor;
import com.jyblues.javamybatis2.util.log.LogingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final LogingInterceptor logingInterceptor;
    private final JwtInterceptor jwtInterceptor;

    @Autowired
    public WebMvcConfig(LogingInterceptor logingInterceptor, JwtInterceptor jwtInterceptor) {
        this.logingInterceptor = logingInterceptor;
        this.jwtInterceptor = jwtInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.logingInterceptor).addPathPatterns("/**"); // JWT 검사를 수행할 API 엔드포인트 패턴 지정
        registry.addInterceptor(this.jwtInterceptor).addPathPatterns("/api/**");
    }
}
