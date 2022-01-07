package com.asaavedras.usuarios.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JWTGeneratorToken {

    public static final String generarJWTToken(String username) {
        String secretKey = "mySecretKey";
        String token = Jwts
                .builder()
                .setSubject(username)
                .claim("authorities",
                        new ArrayList<>())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return token;
    }
}
