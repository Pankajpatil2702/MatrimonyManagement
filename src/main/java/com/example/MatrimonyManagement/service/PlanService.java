package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.Plan;

public interface PlanService {

	Plan savePlan(Plan plan);
	
	List<Plan> getPlan();
	
	Plan getPlanById(int id);
	
	void deletePlanById(int id);
}
