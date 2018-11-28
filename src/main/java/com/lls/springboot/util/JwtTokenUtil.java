package com.lls.springboot.util;

import com.lls.springboot.domain.UserAuthentication;
import com.lls.springboot.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

public class JwtTokenUtil {
    private static final long VALIDITY_TIME_MS = 43200000L;
//    private static final long VALIDITY_TIME_MS = 10000L;
    @Value("${jwt.token.secret}")
    private String secret;
    /**
     * header中标识
     */
    private static final String AUTH_HEADER_NAME = "x-authorization";

    /**
     * 验签
     */
    public Optional<Authentication> verifyToken(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null && !token.isEmpty()){
            final User user = parse(token.trim());
            if (user != null) {
                return Optional.of(new UserAuthentication(user, true));
            }
        }
        return Optional.empty();
    }

    /**
     * 从用户中创建一个jwt Token
     * @param user 用户
     * @return token
     */
    public String create(User user) {


        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + VALIDITY_TIME_MS))
                .setSubject(user.getUsername())
                .claim("id", user.getId().toString())
                .claim("email", user.getEmail())
                .claim("roles", user.getRoles())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * 从token中取出用户
     */
    public User parse(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        User user = new User();
        user.setId(NumberUtils.toLong(claims.get("id",String.class)));
        user.setAvatar(claims.get("avatar",String.class));
        user.setUsername(claims.getSubject());
        user.setEmail(claims.get("email",String.class));
        user.setRoles(claims.get("roles",String.class));
        return user;
    }
}
