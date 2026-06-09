package com.example.instructorapi.security;

import com.example.instructorapi.security.jwt.AuthTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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

    // 1. Tambah ini sebagai field supaya Spring tahu apa itu jwtAuthenticationFilter
    @Autowired
    private AuthTokenFilter jwtAuthenticationFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Pindahkan ke atas
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers(org.springframework.http.HttpMethod.GET, "/api/v1/instructors/**").permitAll()
                .requestMatchers(org.springframework.http.HttpMethod.GET, "/api/v2/instructors/**").permitAll()
                .requestMatchers("/api/v1/reports/**").permitAll() 
                .requestMatchers(org.springframework.http.HttpMethod.POST, "/api/v1/instructors").authenticated()
                .requestMatchers(org.springframework.http.HttpMethod.PUT, "/api/v1/instructors/**").authenticated()
                .requestMatchers(org.springframework.http.HttpMethod.DELETE, "/api/v1/instructors/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            );
            //.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
            
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // ... selebihnya (passwordEncoder dll) kekalkan
}