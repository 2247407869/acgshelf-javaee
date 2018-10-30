package com.lls.springboot.util;

import com.lls.springboot.model.TokenUserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.math.NumberUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.List;

public class JwtUtils {
    private static final long VALIDITY_TIME_MS = 43200000‬;

    /**
     * 从用户中创建一个jwt Token
     * @param userDTO 用户
     * @return token
     */
    public String create(TokenUserDTO userDTO) {
        String base64Security = "jiami";
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key secret = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

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
    public TokenUserDTO parse(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
        TokenUserDTO userDTO = new TokenUserDTO();
        userDTO.setId(NumberUtils.toLong(claims.getId()));
        userDTO.setAvatar(claims.get("avatar",String.class));
        userDTO.setUsername(claims.get("username",String.class));
        userDTO.setEmail(claims.get("email",String.class));
        userDTO.setRoles((List<String>) claims.get("roles"));
        return userDTO;
    }
}
