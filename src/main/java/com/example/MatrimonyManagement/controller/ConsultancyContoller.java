package com.example.MatrimonyManagement.controller;

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
import org.springframework.web.bind.annotation.RestController;
import com.example.MatrimonyManagement.dto.ConsultancyDto;
import com.example.MatrimonyManagement.entities.Consultancy;
import com.example.MatrimonyManagement.service.ConsultancyService;


@RestController
@RequestMapping("/consultancy")
public class ConsultancyContoller {
	
	@Autowired
	private ConsultancyService consultancyService;
	
	
	
	@PostMapping
	public ResponseEntity<Consultancy> saveConsultancy(@RequestBody ConsultancyDto consultancyDto){
		
		Consultancy consultancy = new Consultancy();
		consultancy.setName(consultancyDto.getName());
		consultancy.setEmail(consultancyDto.getEmail());
		consultancy.setPhoneNo(consultancyDto.getPhoneNo());
		consultancy.setAddress(consultancyDto.getAddress());
		consultancy.setCreatedAt(consultancyDto.getCreatedAt());
		
		Consultancy saveConsultancy = consultancyService.saveConsultancy(consultancy);
		
		return new ResponseEntity<>(saveConsultancy , HttpStatus.CREATED);
				
				
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Consultancy>> getAllConsultancy(){
		
		List<Consultancy> consultancy = consultancyService.findAllConsultancies();
		
		if(consultancy == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(consultancy, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consultancy> getConsultancyById(@PathVariable("id") int id){
		
		Consultancy consultancy = consultancyService.getConsultancyById(id);
		
		if(consultancy == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(consultancy, HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Consultancy> updateConsultancyById(@PathVariable("id") int id, @RequestBody ConsultancyDto consultancyDto){
	
		
		Consultancy consultancy = consultancyService.getConsultancyById(id);
		
		if(consultancy ==  null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		consultancy.setName(consultancyDto.getName());
		consultancy.setEmail(consultancyDto.getEmail());
		consultancy.setPhoneNo(consultancyDto.getPhoneNo());
		consultancy.setAddress(consultancyDto.getAddress());
		consultancy.setCreatedAt(consultancyDto.getCreatedAt());
		
		Consultancy updateConsultancy = consultancyService.saveConsultancy(consultancy);
		
		return new ResponseEntity<>(updateConsultancy, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Consultancy> deleteConsultancyById(@PathVariable("id") int id){
		
		Consultancy consultancy = consultancyService.getConsultancyById(id);
		
		if(consultancy == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		consultancyService.deleteConsultancy(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	
	
	
	

}
