package com.hunsun.fund.threadlocal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author
 * @Date 2024/4/11 17:51
 * @Description
 */
@Slf4j
public class UserInfoInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //log.info("接口调用结束， 从ThreadLocal删除用户信息");
        ThreadLocalUtil.remove();
    }
}
