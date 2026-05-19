package com.example.MatrimonyManagement.security;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.example.MatrimonyManagement.response.ErrorResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub

		ErrorResponse errorResponse = new ErrorResponse(
				HttpServletResponse.SC_UNAUTHORIZED,
				"Unauthorized: Invalid or misssing JWT token",
				LocalDateTime.now()
				);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		
		response.setContentType("application/json");
		
		new ObjectMapper().writeValue(response.getOutputStream(), errorResponse);
	}

}
