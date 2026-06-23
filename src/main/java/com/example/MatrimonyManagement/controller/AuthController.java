package com.example.MatrimonyManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.MatrimonyManagement.dto.LoginRequestDto;
import com.example.MatrimonyManagement.response.JwtResponse;
import com.example.MatrimonyManagement.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;
	
	
	@PostMapping("/login/admin")
	public JwtResponse adminLogin(@Valid @RequestBody LoginRequestDto loginRequestDto) {
		
		return authService.adminLogin(loginRequestDto);
	}
	
	
	@PostMapping("/login/customer")
	public JwtResponse customerLogin(@Valid @RequestBody LoginRequestDto loginRequestDto) {
		
		return authService.customerLogin(loginRequestDto);
		
	}
	
	
}
