package com.hunsun.fund.security;

import com.auth0.jwt.JWT;
import com.hundsun.fund.utils.JwtUtil;
import com.hundsun.fund.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;

/**
 * @Author
 * @Date 2024/4/19 20:21
 * @Description
 */

@Component
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    @Lazy
    private RedisUtil redisUtil;

    //private long expireTime;

    /**
     * 设置对应的token类型
     * 必须重写此方法，不然Shiro会报错
     *
     * @param token 令牌
     * @return boolean
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 授权认证
     *
     * @param principalCollection 主要收集
     * @return {@link AuthorizationInfo}
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //log.info("开始进行权限认证.............");

        //获取用户名
        String token = (String) SecurityUtils.getSubject().getPrincipal();

        //创建授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //设置角色
        info.setRoles(new HashSet<>(JWT.decode(token).getClaim("roles").asList(String.class)));

        //设置权限
        info.setStringPermissions(new HashSet<>(JWT.decode(token).getClaim("permissions").asList(String.class)));
        //返回权限实例
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //log.info("开始身份认证.....................");

        //获取token
        String token = (String) authenticationToken.getCredentials();

        if (redisUtil.sIsMember("invalidtoken", token)) throw new AuthenticationException("Token无效，请重新登录!");
        //jwt校验
        if (!JwtUtil.verify(token))
            throw new AuthenticationException("Token失效，请重新登录!");

        // 校验token是否超时失效 & 或者账号密码是否错误
        // if (!jwtTokenRefresh(token, userId, "123")) {
        //     throw new AuthenticationException("Token失效，请重新登录!");
        // }


        //返回身份认证信息
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
