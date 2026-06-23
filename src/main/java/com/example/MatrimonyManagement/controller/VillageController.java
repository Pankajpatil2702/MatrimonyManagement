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

import com.example.MatrimonyManagement.dto.VillageDto;
import com.example.MatrimonyManagement.entities.Taluka;
import com.example.MatrimonyManagement.entities.Village;
import com.example.MatrimonyManagement.service.TalukaService;
import com.example.MatrimonyManagement.service.VillageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/village")
public class VillageController {
	
	@Autowired
	private VillageService villageService;
	
	@Autowired
	private TalukaService talukaService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Village> saveVillageData(@Valid @RequestBody VillageDto villageDto){
		
		Village village = new Village();
		village.setName(villageDto.getName());
		village.setCreatedAt(LocalDateTime.now());
		village.setUpdatedAt(LocalDateTime.now());
		
		Taluka taluka = talukaService.findTalukaById(villageDto.getTalukaId());
		
		if(taluka == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		village.setTalukaId(taluka);
		
		Village saveTaluka = villageService.saveVillage(village);
		
		return new ResponseEntity<>(saveTaluka, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Village>> getAllVillage(){
		
		List<Village> village = villageService.getAllVillage();
		
		if(village == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(village , HttpStatus.OK);
				
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Village> getVillageDataById(@PathVariable("id") int id){
		
		Village village = villageService.getVillageById(id);
		
		if(village == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		return new ResponseEntity<>(village , HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Village> updateVillageById(@Valid @PathVariable("id") int id, @RequestBody VillageDto villageDto){
		
		Village village = villageService.getVillageById(id);
		
		if(village == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		village.setName(villageDto.getName());
		village.setCreatedAt(LocalDateTime.now());
		village.setUpdatedAt(LocalDateTime.now());
		
		Taluka taluka = talukaService.findTalukaById(villageDto.getTalukaId());
		
		if(taluka == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		village.setTalukaId(taluka);
		
		Village updateVillage = villageService.saveVillage(village);
		
		return new ResponseEntity<>(updateVillage , HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Village> deleteVillageDataById(@PathVariable("id") int id){
		
		Village village = villageService.getVillageById(id);
		
		if(village == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		villageService.deleteVillageById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
	}
	
	
	
	
}
