package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.Taluka;

public interface TalukaService {
	
	Taluka saveTaluka(Taluka taluka);
	
	List<Taluka> findAllTaluka();
	
	Taluka findTalukaById(int id);
	
	void deleteTalukaById(int id);

}
