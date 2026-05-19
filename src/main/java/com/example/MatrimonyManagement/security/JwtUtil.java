package com.example.MatrimonyManagement.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.MatrimonyManagement.entities.Role;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	
	private final String SECRET = "ThisIsASecretKeyForJwtTokenGenration12345"; // 32 characters
	
	private final long EXPIRATION = 1000 * 60 * 60 * 24; // 1 day
	
	private Key getSigningKey() {
		
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}
	
	
	public String genrateToken(String email, Role role) {
		
		return Jwts.builder()
				.setSubject(email)
				.claim("role", role)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(getSigningKey(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	
	private Jws<Claims> parseToken(String token){
		
		return Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token);
	}
	
	
	
	public String extractEmail(String token) {
		
		return parseToken(token).getBody().getSubject();
	}
	
	public boolean isValid(String token) {
		
		try {
			
			parseToken(token);
			
			return true;
			
		} catch (Exception e) {
			
			return false;
		}
	}
	
	
	public String extractRole(String token) {
		
		return parseToken(token).getBody().get("role", String.class);
		
	}
	
	
	
	
	

}
