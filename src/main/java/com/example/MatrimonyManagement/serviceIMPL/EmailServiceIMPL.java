package com.example.MatrimonyManagement.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.dto.EmailRequest;
import com.example.MatrimonyManagement.entities.Admin;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.AdminRepository;
import com.example.MatrimonyManagement.response.EmailResponse;
import com.example.MatrimonyManagement.service.EmailService;
import com.example.MatrimonyManagement.service.GenerateOtp;

@Service
public class EmailServiceIMPL implements EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private GenerateOtp generateOtp;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public EmailResponse sendEmail(EmailRequest emailRequest) {
		
		EmailResponse response	= new EmailResponse();
		
		int otp = generateOtp.generateRandomOtp();
		
		Admin admin =  adminRepository.findByEmail(emailRequest.getTo()).orElseThrow(() ->
				new ResourceNotFoundException("User not found with this email: " + emailRequest.getTo()));
		
		admin.setEmailOtp(otp);
		adminRepository.save(admin);
		try {
			
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setTo(emailRequest.getTo());
			message.setSubject("send otp");
			message.setText("Your email verification otp is: " + otp);
			
			mailSender.send(message);
			
			response.setMessage("Email Send Successfully....");
			response.setSuccess(true);
			
		} catch (Exception e) {
			
			response.setMessage("Email failed to send....");
			response.setSuccess(false);
			
		}
		
		return response;
		
	}

}
