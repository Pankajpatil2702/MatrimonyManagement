package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Village;
import com.example.MatrimonyManagement.repositories.VillageRepository;
import com.example.MatrimonyManagement.service.VillageService;

@Service
public class VillageIMPL implements VillageService {

	@Autowired
	private VillageRepository villageRepository;
	@Override
	public Village saveVillage(Village village) {
		// TODO Auto-generated method stub
		return villageRepository.save(village);
	}

	@Override
	public List<Village> getAllVillage() {
		// TODO Auto-generated method stub
		return villageRepository.findAll();
	}

	@Override
	public Village getVillageById(int id) {
		// TODO Auto-generated method stub
		return villageRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteVillageById(int id) {
		// TODO Auto-generated method stub
		villageRepository.deleteById(id);
	}

}
