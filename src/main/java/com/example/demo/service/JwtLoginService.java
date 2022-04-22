package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Component
public class JwtLoginService {
    static final String KEY ="123456";

    public String generateJwtToken(UserEntity userEntity){
        Date now = new Date();
        return Jwts.builder()
                .setSubject(Long.toString(userEntity.getUserId()))
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 125 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    public String parseToken(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getSubject();
    }


}
