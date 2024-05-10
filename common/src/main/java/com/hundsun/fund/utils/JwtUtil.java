package com.hundsun.fund.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hundsun.fund.user.entity.SysPermission;
import com.hundsun.fund.user.entity.SysRole;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class JwtUtil {
    /**
     * JWT验证过期时间 EXPIRE_TIME 分钟
     */
    private static final long EXPIRE_TIME = 30 * 60 * 1000;

    @Setter
    private static String secret = "sda";

    /**
     * 校验token是否正确
     *
     * @param token  token
     * @return 是否正确
     */
    public static boolean verify(String token) {
        try {
            //根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String userId = JWT.decode(token).getClaim("userId").asString();
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userId", userId)
                    .withArrayClaim("roles", JWT.decode(token).getClaim("roles").asArray(String.class))
                    .withArrayClaim("permissions", JWT.decode(token).getClaim("permissions").asArray(String.class))
                    .build();
            //效验TOKEN
            DecodedJWT jwt = verifier.verify(token);
            //log.info("登录验证成功!");
            return true;
        } catch (Exception exception) {
           // log.error("JwtUtil登录验证失败!");
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUserId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成token签名EXPIRE_TIME 分钟后过期
     *
     * @param userId 用户ID
     * @return 加密的token
     */
    public static String sign(String userId, List<SysRole> roles, List<SysPermission> permissions) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 附带username信息
        return JWT.create()
                .withClaim("userId", userId)
                .withClaim("roles", Arrays.asList(roles.stream().map(SysRole::getKey).toArray(String[]::new)))
                .withClaim("permissions", Arrays.asList(permissions.stream().map(SysPermission::getPerm).toArray(String[]::new)))
                .withExpiresAt(date)
                .sign(algorithm);

    }
}

