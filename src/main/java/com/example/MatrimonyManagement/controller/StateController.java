package com.example.MatrimonyManagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

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

import com.example.MatrimonyManagement.dto.StateDto;
import com.example.MatrimonyManagement.entities.State;
import com.example.MatrimonyManagement.service.StateService;

@RestController
@RequestMapping("/state")
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@PostMapping("/")
	public ResponseEntity<State> saveState(@RequestBody StateDto stateDto){
		
		State state = new State();
		
		state.setName(stateDto.getName());
		state.setCreatedAt(LocalDateTime.now());
		state.setUpdatedAt(LocalDateTime.now());
		
		State saveState = stateService.saveState(state);
		
		return new ResponseEntity<>(saveState , HttpStatus.CREATED);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<State>> findAllState(){
		
		List<State> state = stateService.findAllState();
		
		if(state == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(state , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<State> getStateById(@PathVariable("id") int id){
		
		State state  = stateService.getStateById(id);
		
		if(state == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(state , HttpStatus.OK );
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<State> updateState(@PathVariable("id") int id, @RequestBody StateDto stateDto){
		
		State state = stateService.getStateById(id);
		
		if(state == null) {
			
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		state.setName(stateDto.getName());
		state.setCreatedAt(LocalDateTime.now());
		state.setUpdatedAt(LocalDateTime.now());
		
		State updateState = stateService.saveState(state);
		
		return new ResponseEntity<>(updateState , HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<State> deleteStateById(@PathVariable("id") int id){
		
		State state = stateService.getStateById(id);
		
		if(state == null) {
			
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		stateService.deleteStateById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY); 
	}
	
	
	

}
