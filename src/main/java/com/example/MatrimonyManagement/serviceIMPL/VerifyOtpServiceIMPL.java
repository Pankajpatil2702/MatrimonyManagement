package com.example.MatrimonyManagement.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.dto.VerifyEmailOtpDto;
import com.example.MatrimonyManagement.entities.Admin;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.AdminRepository;
import com.example.MatrimonyManagement.response.LoginResponse;
import com.example.MatrimonyManagement.service.VerifyOtpService;

@Service
public class VerifyOtpServiceIMPL implements VerifyOtpService {

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public LoginResponse verfiyEmailOtp(VerifyEmailOtpDto verifyEmailOtpDto) {
		
		Admin admin = adminRepository.findByEmail(verifyEmailOtpDto.getEmail()).orElseThrow( () ->
						new ResourceNotFoundException("Email Not Exist..."));
		
		if(admin.getEmailOtp()!=verifyEmailOtpDto.getOtp()) {
			
			throw new RuntimeException("Invalid otp...");
		}
		admin.setEmailVerify(true);
		admin.setOtpVerify(true); // next added 
		adminRepository.save(admin);
		
		LoginResponse loginResponse = new LoginResponse();
		
		loginResponse.setEmail(verifyEmailOtpDto.getEmail());
		loginResponse.setMessage("Email Verified Successfully....");
		
		return loginResponse;
	}

}
