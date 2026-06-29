package com.example.MatrimonyManagement.service;

import com.example.MatrimonyManagement.dto.VerifyEmailOtpDto;
import com.example.MatrimonyManagement.response.EmailResponse;

public interface VerifyOtpService {

	EmailResponse verfiyEmailOtp(VerifyEmailOtpDto verifyEmailOtpDto);
}
