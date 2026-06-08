package com.example.instructorapi.security;



import com.example.instructorapi.security.jwt.AuthTokenFilter;
import com.example.instructorapi.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    // TAMBAH @Autowired DI SINI:
    @Autowired 
    private AuthTokenFilter jwtAuthenticationFilter; 

    // Tambah juga ini supaya ia tidak jadi null:
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }

   @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            // 1. GET adalah Public
            .requestMatchers(HttpMethod.GET, "/api/v1/instructors/**").permitAll()
            
            // 2. POST & PUT perlukan login (Authenticated)
            .requestMatchers(HttpMethod.POST, "/api/v1/instructors/**").authenticated()
            .requestMatchers(HttpMethod.PUT, "/api/v1/instructors/**").authenticated()
            
            // 3. DELETE perlukan role ADMIN
            .requestMatchers(HttpMethod.DELETE, "/api/v1/instructors/**").hasRole("ADMIN")
            
            // Allow login/register endpoint (contoh)
            .requestMatchers("/api/auth/**").permitAll()
            
            .anyRequest().authenticated()
        );
    
    return http.build();
}
}