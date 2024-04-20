package com.hunsun.fund.security;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author
 * @Date 2024/4/19 20:25
 * @Description
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
