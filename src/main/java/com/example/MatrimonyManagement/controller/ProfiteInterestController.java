
package com.example.MatrimonyManagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MatrimonyManagement.dto.ProfileInterestDto;
import com.example.MatrimonyManagement.entities.Customer;
import com.example.MatrimonyManagement.entities.ProfileInterest;
import com.example.MatrimonyManagement.service.CustomerService;
import com.example.MatrimonyManagement.service.ProfileInterestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/profileinterest")
@CrossOrigin("*")
public class ProfiteInterestController {
	
	@Autowired
	private ProfileInterestService profileInterestService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/register")
	public ResponseEntity<ProfileInterest> saveProfileInterest(@Valid @RequestBody ProfileInterestDto profileInterestDto){
		
		ProfileInterest profileInterest = new ProfileInterest();
		profileInterest.setStatus(profileInterestDto.getStatus());
		profileInterest.setCreatedAt(LocalDateTime.now());
		profileInterest.setUpdatedAt(LocalDateTime.now());
		
		
		Customer from = customerService.getCustomerById(profileInterestDto.getFromCustomer());
		
		Customer to = customerService.getCustomerById(profileInterestDto.getToCustomer());
		
		if(from == null || to == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		profileInterest.setFromCustomer(from);
		
		profileInterest.setToCustomer(to);
		
		ProfileInterest saveInterest = profileInterestService.saveProfileInterest(profileInterest);
		
		return new ResponseEntity<>(saveInterest, HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<ProfileInterest>> getAllProfileInterest(){
		
		List<ProfileInterest> profileInterest = profileInterestService.getAllProfileInterest();
		
		if(profileInterest == null) {
			
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 
		}
		
		return new ResponseEntity<>(profileInterest, HttpStatus.OK);
		
				
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProfileInterest> getProfileInterestById(@PathVariable("id") int id){
		
		ProfileInterest profileInterest = profileInterestService.gertProfileInterestById(id);
		
		if(profileInterest == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(profileInterest, HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProfileInterest> updateProfileInterestById(@Valid @PathVariable("id") int id, @RequestBody ProfileInterestDto profileInterestDto){
		
		ProfileInterest profileInterest = profileInterestService.gertProfileInterestById(id);
		
		if(profileInterest == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		profileInterest.setStatus(profileInterestDto.getStatus());
		profileInterest.setCreatedAt(LocalDateTime.now());
		profileInterest.setUpdatedAt(LocalDateTime.now());
		
		
		Customer from = customerService.getCustomerById(profileInterestDto.getFromCustomer());
		
		Customer to = customerService.getCustomerById(profileInterestDto.getToCustomer());
		
		if(from == null || to == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		profileInterest.setFromCustomer(from);
		
		profileInterest.setToCustomer(to);
		
		ProfileInterest updateProfileInterest = profileInterestService.saveProfileInterest(profileInterest);
		
		return new ResponseEntity<>(updateProfileInterest , HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProfileInterestById(@PathVariable("id") int id){
		
		ProfileInterest profileInterest = profileInterestService.gertProfileInterestById(id);
		
		if(profileInterest == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		profileInterestService.deleteProfileInterestById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY); 
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
