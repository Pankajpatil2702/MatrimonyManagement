package com.example.MatrimonyManagement.serviceIMPL;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.dto.LoginRequestDto;
import com.example.MatrimonyManagement.entities.Admin;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.AdminRepository;
import com.example.MatrimonyManagement.response.JwtResponse;
import com.example.MatrimonyManagement.security.JwtUtil;
import com.example.MatrimonyManagement.service.AuthService;

@Service
public class AuthServiceIMPL implements AuthService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public JwtResponse adminLogin(LoginRequestDto loginRequestDto) {
		
		Admin admin = adminRepository.findByEmail(loginRequestDto.getEmail())
				.orElseThrow( () -> new ResourceNotFoundException("Email not found"));
		
		if(!passwordEncoder.matches(loginRequestDto.getPassword(), admin.getPassword())) {
			
			throw new RuntimeException("Invalid Password");
		}
		
		String token = jwtUtil.genrateToken(admin.getEmail(), admin.getRole());
		
		return new JwtResponse(token, admin.getRole(), admin);
	}

}
