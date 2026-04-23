package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.SubCaste;

public interface SubCasteService {

	SubCaste saveSubCaste(SubCaste caste);
	
	List<SubCaste> findAllSubCaste();
	
	SubCaste findSubCasteById(int id);
	
	void deleteSubCasteById(int id);
}
