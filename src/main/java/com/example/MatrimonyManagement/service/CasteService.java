package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.Caste;

public interface CasteService {
	
	Caste saveCaste(Caste caste);
	
	List<Caste> findAllCaste();
	
	Caste findCasteById(int id);
	
	void delteCasteById(int id);

}
