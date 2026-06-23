package com.example.MatrimonyManagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MatrimonyManagement.dto.TalukaDto;
import com.example.MatrimonyManagement.entities.District;
import com.example.MatrimonyManagement.entities.Taluka;
import com.example.MatrimonyManagement.service.DistrictService;
import com.example.MatrimonyManagement.service.TalukaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/taluka")
public class TalukaController {

	@Autowired
	private TalukaService talukaService;
	
	@Autowired
	private DistrictService districtService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Taluka> saveTaluka(@Valid @RequestBody TalukaDto talukaDto){
		
		Taluka taluka = new Taluka();
		taluka.setTalukaName(talukaDto.getTalukaName());
		taluka.setCreatedAt(LocalDateTime.now());
		taluka.setUpdatedAt(LocalDateTime.now());
		
		District district = districtService.findDistrictById(talukaDto.getDistrictId());
		
		if(district == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		taluka.setDistrictId(district);
		
		Taluka saveTaluka = talukaService.saveTaluka(taluka);
		
		return new ResponseEntity<>(saveTaluka , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Taluka>> getAllTaluka(){
		
		List<Taluka> taluka = talukaService.findAllTaluka();
		
		if(taluka == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(taluka, HttpStatus.OK);
				
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Taluka> getTalukaById(@PathVariable("id") int id){
		
		Taluka taluka = talukaService.findTalukaById(id);
		
		if(taluka == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(taluka, HttpStatus.OK);
				
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Taluka> updateTalukaById(@Valid @PathVariable("id") int id, @RequestBody TalukaDto talukaDto){
		
		Taluka taluka = talukaService.findTalukaById(id);
		
		if(taluka == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		taluka.setTalukaName(talukaDto.getTalukaName());
		taluka.setCreatedAt(LocalDateTime.now());
		taluka.setUpdatedAt(LocalDateTime.now());
		
		District district = districtService.findDistrictById(talukaDto.getDistrictId());
		
		if(district == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		taluka.setDistrictId(district);
		
		Taluka updateTaluka = talukaService.saveTaluka(taluka);
		
		return new ResponseEntity<>(updateTaluka  , HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Taluka> deleteTalukaById(@PathVariable("id") int id){
		
		Taluka taluka = talukaService.findTalukaById(id);
		
		if(taluka == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		talukaService.deleteTalukaById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}
	
	
	
	
	
	
}
