package com.example.MatrimonyManagement.service;

import com.example.MatrimonyManagement.dto.AuthDto;
import com.example.MatrimonyManagement.response.JwtResponse;
import com.example.MatrimonyManagement.response.LoginResponse;

public interface AuthService {

//	LoginResponse userLogin(AuthDto authDto);
	
	JwtResponse adminLogin(AuthDto authDto);
}
