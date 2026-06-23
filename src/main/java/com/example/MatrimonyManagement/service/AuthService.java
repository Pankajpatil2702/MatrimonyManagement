package com.example.MatrimonyManagement.service;

import com.example.MatrimonyManagement.dto.LoginRequestDto;
import com.example.MatrimonyManagement.dto.PasswordResetDto;
import com.example.MatrimonyManagement.response.EmailResponse;
import com.example.MatrimonyManagement.response.JwtResponse;

public interface AuthService {

	JwtResponse adminLogin(LoginRequestDto loginRequestDto);
	
	JwtResponse customerLogin(LoginRequestDto loginRequestDto);
	
	EmailResponse passwordReset(PasswordResetDto passwordResetDto);
}
