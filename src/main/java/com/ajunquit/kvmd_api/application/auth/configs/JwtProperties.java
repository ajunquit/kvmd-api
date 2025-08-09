package com.ajunquit.kvmd_api.application.auth.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@Data
@ConfigurationProperties(prefix = "auth")
public class JwtProperties {
    private String secretBase64;
    private long expirationMs;
}
