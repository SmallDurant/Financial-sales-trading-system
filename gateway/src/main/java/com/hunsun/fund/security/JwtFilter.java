package com.hunsun.fund.security;


import com.auth0.jwt.JWT;
import com.hundsun.fund.exception.ServiceException;
import com.hunsun.fund.threadlocal.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author
 * @Date 2024/4/9 13:51
 * @Description
 */
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter implements Filter {
    /**
     * 执行登录
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws ServiceException{
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Authorization");
        if (token != null){
            ThreadLocalUtil.set("token", token);
            ThreadLocalUtil.set("userId", JWT.decode(token).getClaim("userId").as(String.class));
            ThreadLocalUtil.set("roles",JWT.decode(token).getClaim("roles").asList(String.class));
            ThreadLocalUtil.set("permissions",JWT.decode(token).getClaim("permissions").asList(String.class));
        }


        JwtToken jwtToken = new JwtToken(token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        try {
            // TODO: 解除注释
            // getSubject(request, response).login(jwtToken);

            // 如果没有抛出异常则代表登入成功，返回true
            return true;
        } catch (AuthenticationException e) {
            throw new ServiceException(401, e.getMessage());
        }

    }

    /**
     * 执行登录认证
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        try {
            return executeLogin(request, response);
        } catch (ServiceException e) {
            //log.error("JwtFilter过滤验证失败!");
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            try {
                httpServletResponse.setContentType("application/json;charset=UTF-8");
                httpServletResponse.sendRedirect("/exception/"+e.getCode()+"/"+0);
            } catch (IOException ex) {
                log.error("JwtFilter异常处理重定向失败!");
            }
            return false;
        }
    }

    /**
     * 认证失败时，自定义返回json数据
     *
     * @param request  请求
     * @param response 响应
     * @return boolean* @throws Exception 异常
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response){
        return false;
    }

    /**
     * 对跨域提供支持
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

}
