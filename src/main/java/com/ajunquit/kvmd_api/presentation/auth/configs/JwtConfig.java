package com.ajunquit.kvmd_api.presentation.auth.configs;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ajunquit.kvmd_api.application.auth.configs.JwtProperties;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Configuration
@EnableConfigurationProperties(JwtProperties.class)
public class JwtConfig {
  @Bean
  SecretKey jwtKey(JwtProperties props) {
    byte[] keyBytes = Decoders.BASE64.decode(props.getSecretBase64());
    if (keyBytes.length < 32)
      throw new IllegalArgumentException("JWT secret must be >= 256 bits");
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
