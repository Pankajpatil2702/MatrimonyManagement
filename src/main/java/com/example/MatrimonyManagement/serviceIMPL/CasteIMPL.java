package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Caste;
import com.example.MatrimonyManagement.repositories.CasteRepository;
import com.example.MatrimonyManagement.service.CasteService;

@Service
public class CasteIMPL implements CasteService {

	@Autowired
	private CasteRepository casteRepository;
	
	
	@Override
	public Caste saveCaste(Caste caste) {
		// TODO Auto-generated method stub
		return casteRepository.save(caste);
	}

	@Override
	public List<Caste> findAllCaste() {
		// TODO Auto-generated method stub
		return casteRepository.findAll();
	}

	@Override
	public Caste findCasteById(int id) {
		// TODO Auto-generated method stub
		return casteRepository.findById(id).orElse(null);
	}

	@Override
	public void delteCasteById(int id) {
		// TODO Auto-generated method stub
		casteRepository.deleteById(id);
	}

}
