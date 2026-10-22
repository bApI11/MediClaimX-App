package com.mediclaimx.authservice.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final String SECRET =
            "mysecretkeymysecretkeymysecretkey";

    public String generateToken(String username,
                                String role) {

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis()
                                + 86400000))
                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes()),
                        SignatureAlgorithm.HS256)
                .compact();
    }
}