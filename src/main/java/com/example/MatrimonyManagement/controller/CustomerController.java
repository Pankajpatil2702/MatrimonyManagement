package com.example.MatrimonyManagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MatrimonyManagement.dto.CustomerDto;
import com.example.MatrimonyManagement.entities.Customer;
import com.example.MatrimonyManagement.entities.Role;
import com.example.MatrimonyManagement.service.CustomerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody CustomerDto customerDto){
		
		Customer customer = new Customer();
		
		customer.setName(customerDto.getName());
		customer.setPhoneNo(customerDto.getPhoneNo());
		customer.setEmail(customerDto.getEmail());
		customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
		customer.setRole(Role.Customer);
		
		customer.setCreatedAt(LocalDateTime.now());
		customer.setUpdatedAt(LocalDateTime.now());
		
		
		Customer saveCustomer = customerService.saveCustomer(customer);
		
		return new ResponseEntity<>(saveCustomer, HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		
		List<Customer> customer = customerService.getAllCustomer();
		
		if(customer == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
		
		Customer customer = customerService.getCustomerById(id);
		
		if(customer == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomerById(@Valid @PathVariable("id") int id, @RequestBody CustomerDto customerDto){
		
		Customer customer = customerService.getCustomerById(id);
		
		if(customer ==  null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		customer.setName(customerDto.getName());
		customer.setPhoneNo(customerDto.getPhoneNo());
		customer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
		customer.setRole(Role.Customer);
		
		customer.setCreatedAt(LocalDateTime.now());
		customer.setUpdatedAt(LocalDateTime.now());
		
		
		Customer updateCustomer = customerService.saveCustomer(customer);
		
		return new ResponseEntity<>(updateCustomer , HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") int id){
		
		Customer customer = customerService.getCustomerById(id);
		
		if(customer == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		customerService.deleteCustomerById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY); 
		
	}
	
	
	
}
