package com.hunsun.fund.threadlocal;

import com.auth0.jwt.JWT;
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
public class EmployeeInfoInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        String userId = JWT.decode(token).getClaim("userId").as(String.class);
        ThreadLocalUtil.setEmployeeId(userId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //log.info("接口调用结束， 从ThreadLocal删除用户信息");
        ThreadLocalUtil.remove();
    }
}
