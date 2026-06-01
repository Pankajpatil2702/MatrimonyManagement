package com.example.MatrimonyManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MatrimonyManagement.dto.EmailRequest;
import com.example.MatrimonyManagement.dto.VerifyEmailOtpDto;
import com.example.MatrimonyManagement.response.EmailResponse;
import com.example.MatrimonyManagement.response.LoginResponse;
import com.example.MatrimonyManagement.service.EmailService;
import com.example.MatrimonyManagement.service.VerifyOtpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private VerifyOtpService verifyOtpService;
	
	@PostMapping("/send")
	public ResponseEntity<EmailResponse> sendEmail(@RequestBody EmailRequest emailRequest){
		 
		EmailResponse response = emailService.sendEmail(emailRequest);
		
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/verify-email-otp")
	public LoginResponse loginResponse(@Valid @RequestBody VerifyEmailOtpDto verifyEmailOtpDto) {
		
		return verifyOtpService.verfiyEmailOtp(verifyEmailOtpDto);

	}

}
