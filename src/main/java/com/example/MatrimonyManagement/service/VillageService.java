
package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.Village;

public interface VillageService {

	Village saveVillage(Village village);
	
	List<Village> getAllVillage();
	
	Village getVillageById(int id);
	
	void deleteVillageById(int id);
	
}
