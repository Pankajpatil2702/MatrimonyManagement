package com.example.MatrimonyManagement.service;

import java.util.Random;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GenerateOtp {

	public int generateRandomOtp() {
		
		Random random = new Random();
		return 100000 + random.nextInt(900000);
	}
}
