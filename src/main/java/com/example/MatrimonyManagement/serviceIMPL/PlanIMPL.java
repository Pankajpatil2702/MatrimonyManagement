package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Plan;
import com.example.MatrimonyManagement.repositories.PlanRepository;
import com.example.MatrimonyManagement.service.PlanService;

@Service
public class PlanIMPL implements PlanService {

	@Autowired
	private PlanRepository planRepository;
	
	
	@Override
	public Plan savePlan(Plan plan) {
		// TODO Auto-generated method stub
		return planRepository.save(plan);
	}

	@Override
	public List<Plan> getPlan() {
		// TODO Auto-generated method stub
		return planRepository.findAll();
	}

	@Override
	public Plan getPlanById(int id) {
		// TODO Auto-generated method stub
		return planRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePlanById(int id) {
		// TODO Auto-generated method stub
		planRepository.deleteById(id);
	}

}
