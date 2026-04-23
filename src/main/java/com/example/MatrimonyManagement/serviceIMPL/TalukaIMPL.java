package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Taluka;
import com.example.MatrimonyManagement.repositories.TalukaRepository;
import com.example.MatrimonyManagement.service.TalukaService;

@Service
public class TalukaIMPL implements TalukaService {

	@Autowired
	private TalukaRepository talukaRepository;
	
	@Override
	public Taluka saveTaluka(Taluka taluka) {
		// TODO Auto-generated method stub
		return talukaRepository.save(taluka);
	}

	@Override
	public List<Taluka> findAllTaluka() {
		// TODO Auto-generated method stub
		return talukaRepository.findAll();
	}

	@Override
	public Taluka findTalukaById(int id) {
		// TODO Auto-generated method stub
		return talukaRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteTalukaById(int id) {
		// TODO Auto-generated method stub
		talukaRepository.deleteById(id);
	}

}
