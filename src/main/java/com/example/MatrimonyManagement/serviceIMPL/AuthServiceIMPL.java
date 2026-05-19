package com.example.MatrimonyManagement.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.dto.AuthDto;
import com.example.MatrimonyManagement.entities.Admin;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.AdminRepository;
import com.example.MatrimonyManagement.response.JwtResponse;
import com.example.MatrimonyManagement.response.LoginResponse;
import com.example.MatrimonyManagement.security.JwtUtil;
import com.example.MatrimonyManagement.service.AuthService;

@Service
public class AuthServiceIMPL implements AuthService {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AdminRepository adminRepository;
//	
//	@Override
//	public LoginResponse userLogin(AuthDto authDto) {
//		
//		Admin admin = adminRepository.findByEmail(authDto.getEmail()).orElseThrow( () ->
//				new ResourceNotFoundException("Email not found"));
//		
//		if(!admin.getPassword().equals(authDto.getPassword())) {
//			
//			throw new RuntimeException("Invalid Password...!");
//		}
//		
//		LoginResponse loginResponse = new LoginResponse();
//		loginResponse.setEmail(authDto.getEmail());
//		loginResponse.setMessage("Login Successfully");
//		
//		return loginResponse;
//	}

	@Override
	public JwtResponse adminLogin(AuthDto authDto) {
		
		Admin admin = adminRepository.findByEmail(authDto.getEmail()).orElseThrow( () ->
		new ResourceNotFoundException("Email not found"));

		 if (!passwordEncoder.matches(authDto.getPassword(), admin.getPassword())) {
		        throw new RuntimeException("Invalid Password");
		    }
		
		String token = jwtUtil.genrateToken(admin.getEmail(), admin.getRole());
		return new JwtResponse(token, admin.getRole(), admin);
	}

}
