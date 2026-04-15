package com.example.MatrimonyManagement.controller;

import java.time.LocalDateTime;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MatrimonyManagement.dto.AdminDto;
import com.example.MatrimonyManagement.entities.Admin;
import com.example.MatrimonyManagement.service.AdminSerivce;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private AdminSerivce adminSerivce;
	
	@PostMapping("/")
	public ResponseEntity<Admin> saveAdmin(@RequestBody AdminDto adminDto){
		
		Admin admin = new Admin();
		
		admin.setName(adminDto.getName());
		admin.setEmail(adminDto.getEmail());
		admin.setPassword(adminDto.getPassword());
		admin.setRole(adminDto.getRole());
		admin.setCreatedAt(LocalDateTime.now());
		admin.setUpdatesAt(LocalDateTime.now());
		
		Admin saveAdminData = adminSerivce.saveAdmin(admin);
		
		return new ResponseEntity<>(saveAdminData , HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Admin>> getAllAdmins(){
		

		List<Admin> admin = adminSerivce.getAllAdmin();
		
		if(admin == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(admin , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("id") int id){
		
		Admin admin = adminSerivce.getAdminById(id);
		
		if(admin == null) {
			 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(admin , HttpStatus.OK);
				
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Admin> updateAdminById(@PathVariable("id") int id, @RequestBody AdminDto adminDto){
		
		Admin admin = adminSerivce.getAdminById(id);
		
		if(admin == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		admin.setName(adminDto.getName());
		admin.setEmail(adminDto.getEmail());
		admin.setPassword(adminDto.getPassword());
		admin.setRole(adminDto.getRole());
		admin.setCreatedAt(LocalDateTime.now());
		admin.setUpdatesAt(LocalDateTime.now());
		
		Admin updateAdmin = adminSerivce.saveAdmin(admin);
		
		return new ResponseEntity<>(updateAdmin , HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAdminById(@PathVariable("id") int id){
		
		Admin admin = adminSerivce.getAdminById(id);
		
		if(admin == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		adminSerivce.deleteAdminById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}
	
	
	
	
	
	
	
	
}
