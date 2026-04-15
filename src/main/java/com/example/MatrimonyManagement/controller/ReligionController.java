package com.example.MatrimonyManagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MatrimonyManagement.dto.ReligionDTO;
import com.example.MatrimonyManagement.entities.Religion;
import com.example.MatrimonyManagement.service.ReligionService;

@RestController
@RequestMapping("/religion")
@CrossOrigin
public class ReligionController {
	
	@Autowired
	ReligionService religionService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Religion> saveReligion(@RequestBody ReligionDTO religionDTO){
		Religion religion = new Religion();
		religion.setName(religionDTO.getName());
		religion.setCreatedat(LocalDateTime.now());
	
		Religion saveReligion = religionService.saveReligion(religion);
		return new ResponseEntity<>(saveReligion, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Religion>> getListOfReligions(){
		List<Religion> religions = religionService.getAllReligions();
		if (religions==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<>(religions,HttpStatus.NOT_FOUND);
	}

}
