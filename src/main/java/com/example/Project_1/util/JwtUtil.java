package com.example.Project_1.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys; // PENTING: Tambah baris ini!
import javax.crypto.SecretKey;        // PENTING: Tambah baris ini!
import org.springframework.stereotype.Component;
import java.util.Date;
import com.example.Project_1.model.User;

@Component
public class JwtUtil { 
// Make sure the key is at least 32 characters long for HS256 
private final SecretKey key = Keys.hmacShaKeyFor("So SecretAnd So LongUntil No One Can Guess123!".getBytes()); 
private final long EXPIRATION_TIME = 86400000; 

public String generateToken(User user) { 
return Jwts.builder() 
.setSubject(user.getEmail()) 
.claim("roles", user.getRole().name()) 
.setIssuedAt(new Date()) 
.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) 
.signWith(key) // Use the 'key' object directly 
.compact(); 
} 

public boolean validateToken(String token) { 
try { 
Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token); 
return true; 
} catch (JwtException e) { 
return false; 
} 
} 

public String getEmailFromToken(String token) { 
return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject(); 
} 

public String getRoleFromToken(String token) { 
return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().get("roles", String.class); 
}
}