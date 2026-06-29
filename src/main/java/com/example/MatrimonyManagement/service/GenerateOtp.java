package com.example.MatrimonyManagement.service;

import java.util.Random;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GenerateOtp {

	public long generateRandomOtp() {
		
		Random random = new Random();
		return 100000 + random.nextLong(900000);
	}
}
