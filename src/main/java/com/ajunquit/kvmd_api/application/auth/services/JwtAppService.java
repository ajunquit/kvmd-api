package com.ajunquit.kvmd_api.application.auth.services;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ajunquit.kvmd_api.application.auth.configs.JwtProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtAppService {
  private final SecretKey key;
  private final JwtProperties _jwtProperties;

  public String generateToken(String username) {
    long now = System.currentTimeMillis();
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date(now))
        .setExpiration(new Date(now + _jwtProperties.getExpirationMs()))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }

  public String getUsernameFromToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key).build()
        .parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateToken(String token, UserDetails user) {
    var parser = Jwts.parserBuilder().setSigningKey(key).build();
    var claims = parser.parseClaimsJws(token).getBody();
    return user.getUsername().equals(claims.getSubject()) && claims.getExpiration().after(new Date());
  }
}
