package com.example.instructorapi.security;

import com.example.instructorapi.security.jwt.AuthTokenFilter; // Pastikan path ini betul dengan folder projek anda
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthTokenFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Disable CSRF sebab kita pakai JWT (stateless)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
.authorizeHttpRequests(auth -> auth
    // 1. TAMBAH BARIS INI: Benarkan akses ke endpoint auth
    .requestMatchers("/api/auth/**").permitAll()
    
    // 2. Kemudian baru peraturan yang lain
    .requestMatchers(HttpMethod.GET, "/api/instructors/**").permitAll()
    .requestMatchers(HttpMethod.POST, "/api/instructors/**").authenticated()
    .requestMatchers(HttpMethod.PUT, "/api/instructors/**").authenticated()
    .requestMatchers(HttpMethod.DELETE, "/api/instructors/**").hasRole("ADMIN")
    .anyRequest().authenticated()
)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}