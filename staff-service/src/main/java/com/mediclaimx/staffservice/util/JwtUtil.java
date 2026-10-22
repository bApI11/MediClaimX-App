package com.mediclaimx.staffservice.util;

import org.bouncycastle.jcajce.BCFKSLoadStoreParameter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY =
            "myMediclaimXSecretKeyForJwtAuthentication2026";

    private final long EXPIRATION_TIME =
            1000 * 60 * 60 * 24; // 24 hours

    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("role",
                        userDetails.getAuthorities()
                                .iterator()
                                .next()
                                .getAuthority())
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis()
                                + EXPIRATION_TIME))
                .signWith(
                        BCFKSLoadStoreParameter.SignatureAlgorithm.HS256,
                        SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token) {

        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}