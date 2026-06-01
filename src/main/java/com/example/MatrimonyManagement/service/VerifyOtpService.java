package com.example.MatrimonyManagement.service;

import com.example.MatrimonyManagement.dto.VerifyEmailOtpDto;
import com.example.MatrimonyManagement.response.LoginResponse;

public interface VerifyOtpService {

	LoginResponse verfiyEmailOtp(VerifyEmailOtpDto verifyEmailOtpDto);
}
