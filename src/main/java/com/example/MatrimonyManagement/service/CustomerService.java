package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.Customer;

public interface CustomerService {
	
	Customer saveCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	Customer getCustomerById(int id);
	
	void deleteCustomerById(int id);

}
