package com.example.MatrimonyManagement.dto;

import lombok.Data;

@Data
public class VerifyEmailOtpDto {

	private String email;
	private Long otp;
}
