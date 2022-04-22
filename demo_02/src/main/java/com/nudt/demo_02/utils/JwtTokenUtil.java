package com.nudt.demo_02.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lzy
 * @Time: 2022/4/18
 * @Description: JwtToken生成的工具类
 */
@Component
public class JwtTokenUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 生成 JWT Token
     * 构成: Header.Payload.Signature
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)    //设置payLoad
                .setExpiration(generateExpirationDate())    //设置过期时间
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成 token 过期时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * PayLoad
     * 从 token 中获取JWT中的载荷
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }
        catch (Exception e) {
            LOGGER.info("JWT 格式验证失败 : {}", token);
        }

        return claims;
    }

    private Date getExpireDateFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();    //map.get("exp", Date.Class)
    }

    /**
     *
     * @param token
     * @return True —— 已过期; False —— 未过期
     */
    private boolean isTokenExpired(String token) {
        Date expireDate = getExpireDateFromToken(token);
        return expireDate.before(new Date());
    }

    public String getUserNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();    //从JwtMap中获得username, map.get("sub")
        }
        catch (Exception e) {
            username = null;
        }

        return username;
    }

    /**
     * 验证token是否有效
     * @param token 客户端传入的token
     * @param userDetails 数据库查询的用户信息
     * @return
     */
    public boolean isTokenValidate(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 根据用户信息生成 token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    public boolean canRefresh(String token) {
        return !isTokenExpired(token);
    }

    public String refresh(String token) {
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

}
