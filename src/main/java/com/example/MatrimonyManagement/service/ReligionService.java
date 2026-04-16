package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.Religion;

public interface ReligionService {
	
	Religion saveReligion (Religion religion);
	
	Religion getReligionById(int id);
	
	List<Religion> getAllReligions();
	
	void delteReligion(int id);

}
