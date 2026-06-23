package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.CustomerProfile;
import com.example.MatrimonyManagement.repositories.CustomerProfileRepository;
import com.example.MatrimonyManagement.service.CustomerProfileService;

@Service
public class CustomerProfileIMPL implements CustomerProfileService {

	@Autowired
	private CustomerProfileRepository customerProfileRepository;
	
	@Override
	public CustomerProfile saveCustomerProfile(CustomerProfile customerProfile) {
		// TODO Auto-generated method stub
		return customerProfileRepository.save(customerProfile);
	}

	@Override
	public List<CustomerProfile> getAllCustomerProfile() {
		// TODO Auto-generated method stub
		return customerProfileRepository.findAll();
	}

	@Override
	public CustomerProfile getCustomerProfileById(int id) {
		// TODO Auto-generated method stub
		return customerProfileRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteCustomerProfileById(int id) {
		// TODO Auto-generated method stub
		customerProfileRepository.deleteById(id);
	}

}
