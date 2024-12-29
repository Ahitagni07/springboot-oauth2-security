package com.example.oauth2resource.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests() // Configuring request authorization
                .requestMatchers("/public/**").permitAll()  // Public endpoints don't require authentication
                .anyRequest().authenticated()  // All other endpoints require a valid JWT token
                .and()
                .oauth2ResourceServer()
                .jwt(); // Use JWT authentication
        return http.build();
    }
}
