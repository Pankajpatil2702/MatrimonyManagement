package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.CustomerProfile;

public interface CustomerProfileService {

	CustomerProfile saveCustomerProfile(CustomerProfile customerProfile);
	
	List<CustomerProfile> getAllCustomerProfile();
	
	CustomerProfile getCustomerProfileById(int id);
	
	void deleteCustomerProfileById(int id);
	
	
}
