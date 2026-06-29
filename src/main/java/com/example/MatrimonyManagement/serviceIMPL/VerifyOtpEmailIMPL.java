package com.example.MatrimonyManagement.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.dto.VerifyEmailOtpDto;
import com.example.MatrimonyManagement.entities.Admin;
import com.example.MatrimonyManagement.entities.Customer;
import com.example.MatrimonyManagement.repositories.AdminRepository;
import com.example.MatrimonyManagement.repositories.CustomerRepository;
import com.example.MatrimonyManagement.response.EmailResponse;
import com.example.MatrimonyManagement.service.VerifyOtpService;

@Service
public class VerifyOtpEmailIMPL implements VerifyOtpService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public EmailResponse verfiyEmailOtp(VerifyEmailOtpDto verifyEmailOtpDto) {
		
		EmailResponse response = new EmailResponse();

        // Admin Check
        Admin admin = adminRepository.findByEmail(verifyEmailOtpDto.getEmail())
                .orElse(null);

        if (admin != null) {

            if (admin.getOtp() != null &&
                    admin.getOtp().equals(verifyEmailOtpDto.getOtp())) {

                admin.setOtpVerify(true);
                admin.setOtp(null);

                adminRepository.save(admin);

                response.setSuccess(true);
                response.setMessage("Admin OTP Verified Successfully");

                return response;
            }

            response.setSuccess(false);
            response.setMessage("Invalid OTP");

            return response;
        }

        // Customer Check
        Customer customer = customerRepository.findByEmail(verifyEmailOtpDto.getEmail())
                .orElse(null);

        if (customer != null) {

            if (customer.getOtp() != null &&
                    customer.getOtp().equals(verifyEmailOtpDto.getOtp())) {

                customer.setIsOtpVerified(true);
                customer.setOtp(null);

                customerRepository.save(customer);

                response.setSuccess(true);
                response.setMessage("Customer OTP Verified Successfully");

                return response;
            }

            response.setSuccess(false);
            response.setMessage("Invalid OTP");

        }
        return response;
    }
}
	
	
	
	
	
	
	
	
	
	
	


