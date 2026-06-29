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

import com.example.MatrimonyManagement.dto.SubCasteDto;
import com.example.MatrimonyManagement.entities.Caste;
import com.example.MatrimonyManagement.entities.SubCaste;
import com.example.MatrimonyManagement.service.CasteService;
import com.example.MatrimonyManagement.service.SubCasteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/subcaste")
@CrossOrigin("*")
public class SubCasteController {

	@Autowired
	private SubCasteService subCasteService;
	
	@Autowired
	private CasteService casteService;
	
	
	@PostMapping("/register")
	public ResponseEntity<SubCaste> saveSubCaste(@Valid @RequestBody SubCasteDto subCasteDto){
		
		SubCaste subCaste = new SubCaste();
		subCaste.setSubCasteName(subCasteDto.getSubCasteName());
		subCaste.setCreatedAt(LocalDateTime.now());
		subCaste.setUpdatedAt(LocalDateTime.now());
		
		Caste caste = casteService.findCasteById(subCasteDto.getCasteId());
		
		if(caste == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		subCaste.setCasteId(caste);
		
		SubCaste saveSubCaste = subCasteService.saveSubCaste(subCaste);
		
		return new ResponseEntity<>(saveSubCaste , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<SubCaste>> getAllSubCaste(){
		
		List<SubCaste> subCaste = subCasteService.findAllSubCaste();
		
		if(subCaste == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(subCaste, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SubCaste> getSubCasteById(@PathVariable("id") int id){
		
		SubCaste subCaste = subCasteService.findSubCasteById(id);
				
		if(subCaste == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(subCaste, HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<SubCaste> updateSubCasteById(@Valid @PathVariable("id") int id, @RequestBody SubCasteDto subCasteDto){
		
		SubCaste subCaste = new SubCaste();
		subCaste.setSubCasteName(subCasteDto.getSubCasteName());
		subCaste.setCreatedAt(LocalDateTime.now());
		subCaste.setUpdatedAt(LocalDateTime.now());
		
		Caste caste = casteService.findCasteById(subCasteDto.getCasteId());
		
		if(caste == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		subCaste.setCasteId(caste);
		
		SubCaste updateSubCaste = subCasteService.saveSubCaste(subCaste);
		
		return new ResponseEntity<>(updateSubCaste, HttpStatus.OK);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<SubCaste> deleteSubCasteById(@PathVariable("id") int id){
		
		SubCaste subCaste = subCasteService.findSubCasteById(id);
		
		if(subCaste == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
				
	}
	
	
	
	
	
	
	
}
