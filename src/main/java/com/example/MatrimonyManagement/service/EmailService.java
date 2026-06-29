 package com.example.MatrimonyManagement.service;

import com.example.MatrimonyManagement.dto.EmailRequest;
import com.example.MatrimonyManagement.response.EmailResponse;

public interface EmailService {

//	EmailResponse sendEmail(EmailRequest emailRequest);
	
	EmailResponse adminEmail(EmailRequest emailRequest);
	
	EmailResponse customerEmail(EmailRequest emailRequest);
}
