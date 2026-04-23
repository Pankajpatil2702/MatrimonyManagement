package com.example.MatrimonyManagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MatrimonyManagement.dto.ConsultancyUserDto;
import com.example.MatrimonyManagement.entities.Consultancy;
import com.example.MatrimonyManagement.entities.ConsultancyUser;
import com.example.MatrimonyManagement.service.ConsultancyService;
import com.example.MatrimonyManagement.service.ConsultancyUserService;

@RestController
@RequestMapping("/consultancyUser")
public class consultancyUserController {
	
	@Autowired
	private ConsultancyUserService consultancyUserService;
	
	@Autowired
	private ConsultancyService consultancyService;
	
	@PostMapping("/")
	public ResponseEntity<ConsultancyUser> saveConsultancyUser(@RequestBody ConsultancyUserDto consultancyUserDto){
		
		ConsultancyUser consultancyUser = new ConsultancyUser();
		consultancyUser.setName(consultancyUserDto.getName());
		consultancyUser.setEmail(consultancyUserDto.getEmail());
		consultancyUser.setPassword(consultancyUserDto.getPassword());
		consultancyUser.setRole(consultancyUserDto.getRole());
		consultancyUser.setCreatedAt(LocalDateTime.now());
		consultancyUser.setUpdatedAt(LocalDateTime.now());
		
		Consultancy consultancy = consultancyService.getConsultancyById(consultancyUserDto.getConsultancyId());
		
		if(consultancy == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		consultancyUser.setConsultancyId(consultancy);
		
		ConsultancyUser saveConsultancyUser = consultancyUserService.saveConsultancyUser(consultancyUser);
		
		return new ResponseEntity<>(saveConsultancyUser, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ConsultancyUser>> getAllConsultancyUser(){
		
		List<ConsultancyUser> consultancyUser = consultancyUserService.getAllConsultancyUser();
		
		if(consultancyUser ==  null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(consultancyUser , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsultancyUser> getConsultancyUserById(@PathVariable("id") int id){
		
		ConsultancyUser consultancyUser = consultancyUserService.getConsultancyUserById(id);
		
		if(consultancyUser ==  null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(consultancyUser , HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ConsultancyUser> updateConsultancyUserById(@PathVariable("id") int id, @RequestBody ConsultancyUserDto consultancyUserDto){
		
		ConsultancyUser consultancyUser = consultancyUserService.getConsultancyUserById(id);
		if(consultancyUser ==  null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		consultancyUser.setName(consultancyUserDto.getName());
		consultancyUser.setEmail(consultancyUserDto.getEmail());
		consultancyUser.setPassword(consultancyUserDto.getPassword());
		consultancyUser.setRole(consultancyUserDto.getRole());
		consultancyUser.setCreatedAt(LocalDateTime.now());
		consultancyUser.setUpdatedAt(LocalDateTime.now());
		
		Consultancy consultancy = consultancyService.getConsultancyById(consultancyUserDto.getConsultancyId());
		
		if(consultancy == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		consultancyUser.setConsultancyId(consultancy);
		
		ConsultancyUser updateConsultancyUser = consultancyUserService.saveConsultancyUser(consultancyUser);
		
		return new ResponseEntity<>(updateConsultancyUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ConsultancyUser> deleteConsultancyUserById(@PathVariable("id") int id){
		
		ConsultancyUser consultancyUser = consultancyUserService.getConsultancyUserById(id);
		if(consultancyUser == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		consultancyUserService.deleteConsultancyUserById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);	
		
	}
	
	

}
