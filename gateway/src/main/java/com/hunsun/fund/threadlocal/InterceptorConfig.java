package com.hunsun.fund.threadlocal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author
 * @Date 2024/5/5 下午11:38
 * @Description
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(employeeInfoInterceptor())
                .addPathPatterns("/**");////拦截所有请求,通过判断token是否合法来决定是否需要登
    }

    @Bean
    public EmployeeInfoInterceptor employeeInfoInterceptor(){
        return new EmployeeInfoInterceptor();
    }
}
