package com.yls.word_springboot.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import java.util.Date;

@Component
public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String  generateToken(String username) {
        return JWT.create()
                .withSubject(username) // 设置主题（用户标识）
                .withIssuedAt(new Date()) // 发行时间
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration)) // 过期时间
                .sign(Algorithm.HMAC256(secret)); // 使用 HMAC256 算法签名
    }

    // 验证并解析 JWT 令牌
    public DecodedJWT verifyToken(String token) throws JWTVerificationException {
        return JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token); // 验证令牌并返回解码后的 JWT
    }

    // 从令牌中提取用户名
    public String getUsernameFromToken(String token) {
        try {
            logger.debug("Decoding token: {}", token);

            DecodedJWT jwt = JWT.decode(token);
            String username = jwt.getSubject();
            logger.debug("Extracted username: {}", username);
            return username;
        } catch (Exception e) {
            logger.error("Failed to decode token: {}", e.getMessage());
            return null;
        }
    }
}
