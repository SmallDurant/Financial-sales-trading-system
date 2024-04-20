package com.hunsun.fund.threadlocal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author
 * @Date 2024/4/20 15:03
 * @Description
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(employeeInfoInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public UserInfoInterceptor employeeInfoInterceptor(){
        return new UserInfoInterceptor();
    }
}
