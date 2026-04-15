package com.example.MatrimonyManagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.example.MatrimonyManagement.dto.PlanDto;
import com.example.MatrimonyManagement.entities.Plan;
import com.example.MatrimonyManagement.service.PlanService;

@RestController
@RequestMapping("/plan")
public class PlanController {
	
	@Autowired
	private PlanService planService;
	
	
	@PostMapping("/")
	public ResponseEntity<Plan> savePlan(@RequestBody PlanDto planDto){
		
		Plan plan = new Plan();
		
		plan.setName(planDto.getName());
		plan.setPrice(planDto.getPrice());
		plan.setDuration(planDto.getDuration());
		plan.setDescription(planDto.getDescription());
		plan.setCreatedAt(LocalDateTime.now());
		plan.setUpdatedAt(LocalDateTime.now());
		
		Plan savePlan = planService.savePlan(plan);
		return new ResponseEntity<>(savePlan , HttpStatus.CREATED);
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Plan>> getAllPlans(){
		
		List<Plan> plan = planService.getPlan();
		
		if(plan == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		
		return new ResponseEntity<>(plan , HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Plan> getPlanById(@PathVariable("id")int id){
		
		Plan plan = planService.getPlanById(id);	
		if(plan == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(plan,HttpStatus.OK);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<Plan> updatePlan(@PathVariable("id") int id,@RequestBody PlanDto planDto ){
		Plan plan = planService.getPlanById(id);	
		if(plan == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		plan.setName(planDto.getName());
		plan.setPrice(planDto.getPrice());
		plan.setDuration(planDto.getDuration());
		plan.setDescription(planDto.getDescription());
		plan.setCreatedAt(LocalDateTime.now());
		plan.setUpdatedAt(LocalDateTime.now());
		
		Plan savePlan = planService.savePlan(plan);
		return new ResponseEntity<>(savePlan , HttpStatus.CREATED);
	}
	
	
	
	
	
	


}
