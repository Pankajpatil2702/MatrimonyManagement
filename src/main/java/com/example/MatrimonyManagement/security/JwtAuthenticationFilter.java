package com.example.MatrimonyManagement.security;

import java.io.IOException;
import java.security.SignatureException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.MatrimonyManagement.response.ErrorResponse;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, 
									HttpServletResponse response,
									FilterChain filterChain)
			throws ServletException, IOException {
		
		try {
			
			String authHeader = request.getHeader("Authorization");
			
			if(authHeader == null || !authHeader.startsWith("Bearer ")) {
				
				filterChain.doFilter(request, response);
				return ;
			}
			
			String token = authHeader.substring(7);
			
			if(jwtUtil.isValid(token)) {
				
				String email = jwtUtil.extractEmail(token);
				String role = jwtUtil.extractRole(token);
				
				SimpleGrantedAuthority authority =
						new SimpleGrantedAuthority("ROLE_" + role);
				
				UsernamePasswordAuthenticationToken authentication = 
						new UsernamePasswordAuthenticationToken(
								email,
								null,
								List.of(authority)
						);
				SecurityContextHolder.getContext()
						.setAuthentication(authentication);
			}
			
			filterChain.doFilter(request, response);
			
		} catch (ExpiredJwtException e) {
			sendError(response, "JWT token expired");
			
		} catch (MalformedJwtException e) {
			sendError(response, "Invalid JWT token");
			
		} 
		
	}
	
	private void sendError(HttpServletResponse response, String message) throws IOException {
		
		ErrorResponse error = new ErrorResponse(
				HttpServletResponse.SC_UNAUTHORIZED,
				message,
				LocalDateTime.now()
		);
		response.resetBuffer();
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        
        new ObjectMapper().writeValue(response.getOutputStream(), error);
	}
	
	
	
	
	
	
	
	
	
	

}
