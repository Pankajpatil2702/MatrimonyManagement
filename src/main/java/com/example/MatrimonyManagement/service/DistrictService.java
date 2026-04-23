package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.District;

public interface DistrictService {

	District saveDistrict(District district);
	
	List<District> findAllDistrict();
	
	District findDistrictById(int id);
	
	void deleteDistrictById(int id);
	
}
