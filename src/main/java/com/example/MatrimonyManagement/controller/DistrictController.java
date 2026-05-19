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
import org.springframework.web.bind.annotation.RestController;

import com.example.MatrimonyManagement.dto.DistrictDto;
import com.example.MatrimonyManagement.entities.District;
import com.example.MatrimonyManagement.entities.State;
import com.example.MatrimonyManagement.service.DistrictService;
import com.example.MatrimonyManagement.service.StateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/district")
public class DistrictController {
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private StateService stateService;
	
	
	@PostMapping("/")
	public ResponseEntity<District> saveDistrict(@Valid @RequestBody DistrictDto districtDto){
		
		District district = new District();
		district.setDistrictName(districtDto.getDistrictName());
		district.setCreatedAt(LocalDateTime.now());
		district.setUpdatedAt(LocalDateTime.now());
		
		State state = stateService.getStateById(districtDto.getStateId());
		
		if(state == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		district.setStateId(state);
		
		District saveDistrict = districtService.saveDistrict(district);
		
		return new ResponseEntity<>(saveDistrict , HttpStatus.CREATED);
				
	}
	
	@GetMapping("/")
	public ResponseEntity<List<District>> getAllDistrict(){
		
		List<District> district = districtService.findAllDistrict();
				
		if(district == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		
		return new ResponseEntity<>(district , HttpStatus.OK);
						
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<District> getDistrictById(@PathVariable("id") int id){
		
		District district = districtService.findDistrictById(id);
				
		if(district == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		
		return new ResponseEntity<>(district , HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<District> updateDistrictById(@Valid @PathVariable("id") int id, @RequestBody DistrictDto districtDto){
		
		District district = districtService.findDistrictById(id);
		
		if(district == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		
		district.setDistrictName(districtDto.getDistrictName());
		district.setCreatedAt(LocalDateTime.now());
		district.setUpdatedAt(LocalDateTime.now());
		
		State state = stateService.getStateById(districtDto.getStateId());
		
		if(state == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		district.setStateId(state);
		
		District updateDistrict = districtService.saveDistrict(district);
		
		return new ResponseEntity<>(updateDistrict , HttpStatus.OK);
				
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<District> deleteDsitrictById(@PathVariable("id") int id){
		
		District district = districtService.findDistrictById(id);
		
		if(district == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		
		districtService.deleteDistrictById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
				
		 
	}
	
	

}
