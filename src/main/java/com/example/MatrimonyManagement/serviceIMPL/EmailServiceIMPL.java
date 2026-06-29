package com.example.MatrimonyManagement.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.dto.EmailRequest;
import com.example.MatrimonyManagement.entities.Admin;
import com.example.MatrimonyManagement.entities.Customer;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.AdminRepository;
import com.example.MatrimonyManagement.repositories.CustomerRepository;
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
	
	@Autowired
	private CustomerRepository customerRepository;
	
//	@Override
//	public EmailResponse sendEmail(EmailRequest emailRequest) {
//		
//		EmailResponse response	= new EmailResponse();
//		
//		int otp = generateOtp.generateRandomOtp();
//		
//		Admin admin =  adminRepository.findByEmail(emailRequest.getTo()).orElseThrow(() ->
//				new ResourceNotFoundException("User not found with this email: " + emailRequest.getTo()));
//		
//		admin.setEmailOtp(otp);
//		adminRepository.save(admin);
//		try {
//			
//			SimpleMailMessage message = new SimpleMailMessage();
//			
//			message.setTo(emailRequest.getTo());
//			message.setSubject("send otp");
//			message.setText("Your email verification otp is: " + otp);
//			
//			mailSender.send(message);
//			
//			response.setMessage("Email Send Successfully....");
//			response.setSuccess(true);
//			
//		} catch (Exception e) {
//			
//			response.setMessage("Email failed to send....");
//			response.setSuccess(false);
//			
//		}
//		
//		return response;
//		
//	}

	
	
	@Override
	public EmailResponse adminEmail(EmailRequest emailRequest) {
		
		Admin admin = adminRepository.findByEmail(emailRequest.getEmail()).orElseThrow( ()->
						new ResourceNotFoundException("Email is Invalid"));   
		
		Long otp = generateOtp.generateRandomOtp();
		
		EmailResponse emailResponse = new EmailResponse();
		
		try {
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setTo(emailRequest.getEmail());
			mailMessage.setSubject("OTP Verification");
			mailMessage.setText("Your OTP is: " + otp);
			
			mailSender.send(mailMessage);
			
			admin.setOtp(otp);
			adminRepository.save(admin);
			
			emailResponse.setSuccess(true);
			emailResponse.setMessage("Email Send Successfully");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			emailResponse.setSuccess(false);
			emailResponse.setMessage("Failed to sent Email");
			
		}
		
		return emailResponse;
	}

	@Override
	public EmailResponse customerEmail(EmailRequest emailRequest) {
		
		if(emailRequest.getEmail() == null || emailRequest.getEmail().isBlank()) {
		    throw new IllegalArgumentException("Email cannot be empty");
		}
		
		Customer customer = customerRepository.findByEmail(emailRequest.getEmail()).orElseThrow( ()-> new ResourceNotFoundException("Email not Found")); 
		
		  long otp = generateOtp.generateRandomOtp();
		  
		  EmailResponse emailResponse = new EmailResponse();
		  
		  try {
			
			  SimpleMailMessage mailMessage = new SimpleMailMessage();
			  
			  mailMessage.setTo(emailRequest.getEmail());
			  mailMessage.setSubject("OTP Verification");
			  mailMessage.setText("Your OTP is: " + otp);
			  
			  mailSender.send(mailMessage);
			  
			  customer.setOtp(otp);
			  customerRepository.save(customer);
			  
			  emailResponse.setSuccess(true);
			  emailResponse.setMessage("Email Send Succesfully");
			  
			} catch (Exception e) {
				
				e.printStackTrace();
				emailResponse.setSuccess(false);
				emailResponse.setMessage("Failed to send customer Email");
			}
		
		return emailResponse;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
