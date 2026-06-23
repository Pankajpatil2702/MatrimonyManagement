package com.example.MatrimonyManagement.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MatrimonyManagement.dto.BioDataDto;
import com.example.MatrimonyManagement.service.BioDataService;

@RestController
@RequestMapping("/biodata")
public class BioDataController {

	@Autowired
	private BioDataService bioDataService;
	
	@PostMapping("/download")
	public ResponseEntity<byte[]> downloadBioData(@RequestBody BioDataDto bioDataDto){
		
		byte[] pdf = bioDataService.generateBioData(bioDataDto);
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDispositionFormData("attachment", "biodata.pdf");
		
		return new ResponseEntity<>(pdf, headers , HttpStatus.OK);
	}
	
}
