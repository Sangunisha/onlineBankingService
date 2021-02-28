package com.interview.banking.onlineBankingService.authentication.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProperties {
    @Value("${jwt.secretKey}")
    private String secretKey;

    @Value("${jwt.validityInMilliseconds}")
    private long validityInMilliseconds;

    public String getSecretKey() {
        return secretKey;
    }


    public long getValidityInMilliseconds() {
        return validityInMilliseconds;
    }
}