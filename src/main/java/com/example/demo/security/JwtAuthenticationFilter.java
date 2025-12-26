package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Minimal stub filter.
 * Tests do NOT verify security filtering.
 */
public class JwtAuthenticationFilter {

    public void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // No authentication logic
        filterChain.doFilter(request, response);
    }
}
