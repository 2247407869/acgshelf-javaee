package com.lls.springboot.util;

import com.lls.springboot.model.UserAuthentication;
import com.lls.springboot.model.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class JwtTokenUtil {
    private static final long VALIDITY_TIME_MS = 43200000L;
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
            final UserDTO user = parse(token.trim());
            if (user != null) {
                return Optional.of(new UserAuthentication(user, true));
            }
        }
        return Optional.empty();
    }

    /**
     * 从用户中创建一个jwt Token
     * @param userDTO 用户
     * @return token
     */
    public String create(UserDTO userDTO) {


        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + VALIDITY_TIME_MS))
                .setSubject(userDTO.getUsername())
                .claim("id", userDTO.getId())
                .claim("avatar", userDTO.getAvatar())
                .claim("email", userDTO.getEmail())
                .claim("roles", userDTO.getRoles())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    /**
     * 从token中取出用户
     */
    public UserDTO parse(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(NumberUtils.toLong(claims.getId()));
        userDTO.setAvatar(claims.get("avatar",String.class));
        userDTO.setUsername(claims.get("username",String.class));
        userDTO.setEmail(claims.get("email",String.class));
        userDTO.setRoles(claims.get("roles",String.class));
        return userDTO;
    }
}
