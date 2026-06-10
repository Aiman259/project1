package com.example.Project_1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter; // Cukup letak sekali sahaja

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

 @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/auth/**").permitAll()
            
            // 1. GET: Public (Tanpa token)
            .requestMatchers(HttpMethod.GET, "/api/v1/instructors/**").permitAll()
            
            // 2. POST & PUT: Perlu login (Mana-mana user/admin dengan token)
            .requestMatchers(HttpMethod.POST, "/api/v1/instructors/**").hasAnyRole("USER", "ADMIN")
            .requestMatchers(HttpMethod.PUT, "/api/v1/instructors/**").hasAnyRole("USER", "ADMIN")
            
            // 3. DELETE: Admin Sahaja
            .requestMatchers(HttpMethod.DELETE, "/api/v1/instructors/**").hasRole("ADMIN")
            
            .anyRequest().authenticated()
        );
    return http.build();
}
}