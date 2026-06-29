package com.example.MatrimonyManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.MatrimonyManagement.dto.EmailRequest;
import com.example.MatrimonyManagement.dto.PasswordResetDto;
import com.example.MatrimonyManagement.dto.VerifyEmailOtpDto;
import com.example.MatrimonyManagement.response.EmailResponse;
import com.example.MatrimonyManagement.service.AuthService;
import com.example.MatrimonyManagement.service.EmailService;
import com.example.MatrimonyManagement.service.VerifyOtpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private VerifyOtpService verifyOtpService;
	
//	@PostMapping("/send")
//	public ResponseEntity<EmailResponse> sendEmail(@RequestBody EmailRequest emailRequest){
//		 
//		EmailResponse response = emailService.sendEmail(emailRequest);
//		
//		return ResponseEntity.ok(response);   
//	}
	 
	@PostMapping("/verify-email-otp")
	public EmailResponse loginResponse(@Valid @RequestBody VerifyEmailOtpDto verifyEmailOtpDto) {
		
		return verifyOtpService.verfiyEmailOtp(verifyEmailOtpDto);

	}  

	@PostMapping("/password-reset")
	public EmailResponse passworReset(@Valid @RequestBody PasswordResetDto passwordResetDto) {
		
		return authService.passwordReset(passwordResetDto);
	}
	
	@PostMapping("/customer/mailsend")
	public EmailResponse customerMailSend(@Valid @RequestBody EmailRequest emailRequest) {
		
		return emailService.customerEmail(emailRequest);
		
	}
	
	@PostMapping("/admin/mailsend")
	public EmailResponse adminMailSend(@Valid @RequestBody EmailRequest emailRequest) {
		
		return emailService.adminEmail(emailRequest);
	}
	
	    
}
