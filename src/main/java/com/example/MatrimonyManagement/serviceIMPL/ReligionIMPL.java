package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Religion;
import com.example.MatrimonyManagement.repositories.ReligionRepository;
import com.example.MatrimonyManagement.service.ReligionService;
@Service
public class ReligionIMPL implements ReligionService {
	@Autowired
	ReligionRepository religionRepository;

	@Override
	public Religion saveReligion(Religion religion) {
		// TODO Auto-generated method stub
		return religionRepository.save(religion);
	}

	@Override
	public Religion getReligionById(int id) {
		// TODO Auto-generated method stub
		return religionRepository.findById(id).orElse(null);
	}

	@Override
	
	public List<Religion> getAllReligions() {
		// TODO Auto-generated method stub
		return religionRepository.findAll();
	}

	@Override
	public void delteReligion(int id) {
		religionRepository.deleteById(id);

	}

}
