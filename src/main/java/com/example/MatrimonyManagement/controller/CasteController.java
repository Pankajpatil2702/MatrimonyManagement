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

import com.example.MatrimonyManagement.dto.CasteDto;
import com.example.MatrimonyManagement.entities.Caste;
import com.example.MatrimonyManagement.entities.Religion;
import com.example.MatrimonyManagement.service.CasteService;
import com.example.MatrimonyManagement.service.ReligionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/caste")
public class CasteController {
	
	@Autowired
	private CasteService casteService;
	
	@Autowired
	private ReligionService religionService;
	
	@PostMapping("/register")
	public ResponseEntity<Caste> saveCaste(@Valid @RequestBody CasteDto casteDto){
		
		Caste caste = new Caste();
		caste.setCasteName(casteDto.getCasteName());
		caste.setCreatedAt(LocalDateTime.now());
		caste.setUpdatedAt(LocalDateTime.now());
		
		Religion religion = religionService.getReligionById(casteDto.getReligionId());
		
		if(religion == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
		}
		caste.setReligionId(religion);
		
		Caste saveCaste = casteService.saveCaste(caste);
		
		return new ResponseEntity<>(saveCaste, HttpStatus.CREATED);
				
	}

	
	@GetMapping("/")
	public ResponseEntity<List<Caste>> findAllCaste(){
		
		List<Caste> caste = casteService.findAllCaste();
		
		if(caste == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
								
		}
		
		return new ResponseEntity<>(caste , HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Caste> getCasteById(@PathVariable("id") int id){
		
		Caste caste = casteService.findCasteById(id);
		
		if(caste == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(caste , HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Caste> updateCaste(@Valid @PathVariable("id") int id, @RequestBody CasteDto casteDto){
		
		Caste caste = casteService.findCasteById(id);
		
		caste.setCasteName(casteDto.getCasteName());
		caste.setCreatedAt(LocalDateTime.now());
		caste.setUpdatedAt(LocalDateTime.now());
		
		Religion religion = religionService.getReligionById(casteDto.getReligionId());
		
		if(religion == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
		}
		caste.setReligionId(religion);
		
		Caste updateCaste = casteService.saveCaste(caste);
		
		return new ResponseEntity<>(updateCaste, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/")
	public ResponseEntity<Void> deleteCasteById(@PathVariable("id") int id){
		
		Caste caste = casteService.findCasteById(id);
		if(caste == null) {
					
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	
		}
		casteService.delteCasteById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}
	
	
	
	
}
