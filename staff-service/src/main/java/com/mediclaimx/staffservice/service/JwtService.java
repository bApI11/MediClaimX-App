package com.mediclaimx.staffservice.service;

import com.mediclaimx.staffservice.config.StaffPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration-ms:900000}")
    private long expirationMs;

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(StaffPrincipal staff) {

        Instant now = Instant.now();

        return Jwts.builder()
                .subject(String.valueOf(staff.getId()))
                .claim("staffId", staff.getId())
                .claim("email", staff.getEmail())
                .claim("role", staff.getStaffRole().name())
                .issuedAt(Date.from(now))
                .expiration(
                        Date.from(now.plusMillis(expirationMs))
                )
                .signWith(getSigningKey())
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenValid(String token) {
        try {
            Claims claims = extractClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }
}