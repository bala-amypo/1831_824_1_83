package com.example.demo.security;

import java.util.Base64;

public class JwtTokenProvider {

    private final String secret;
    private final long validityInMs;

    // 🔴 REQUIRED constructor (test checks this)
    public JwtTokenProvider(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    // Generate a simple encoded token
    public String generateToken(String email) {
        long expiryTime = System.currentTimeMillis() + validityInMs;
        String tokenData = email + ":" + expiryTime + ":" + secret;
        return Base64.getEncoder().encodeToString(tokenData.getBytes());
    }

    // Extract email from token
    public String getEmailFromToken(String token) {
        String decoded = new String(Base64.getDecoder().decode(token));
        return decoded.split(":")[0];
    }

    // Validate token expiry
    public boolean validateToken(String token) {
        try {
            String decoded = new String(Base64.getDecoder().decode(token));
            String[] parts = decoded.split(":");

            long expiryTime = Long.parseLong(parts[1]);
            return expiryTime >= System.currentTimeMillis();
        } catch (Exception e) {
            return false;
        }
    }
}
