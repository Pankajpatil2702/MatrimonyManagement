package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Caste;
import com.example.MatrimonyManagement.exception.DataBaseException;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.CasteRepository;
import com.example.MatrimonyManagement.service.CasteService;

@Service
public class CasteIMPL implements CasteService {

	@Autowired
	private CasteRepository casteRepository;
	
	
	@Override
	public Caste saveCaste(Caste caste) {
		
		try {
			
			// TODO Auto-generated method stub
			return casteRepository.save(caste);
			
		} catch (Exception e) {
			throw new DataBaseException("Failed to save caste due to database error");
		}
	}

	@Override
	public List<Caste> findAllCaste() {
		
		try {
			
			// TODO Auto-generated method stub
			return casteRepository.findAll();
			
		} catch (Exception e) {
			
			throw new DataBaseException("Failed to find caste due to datbase error");
		}
	}

	@Override
	public Caste findCasteById(int id) {
		// TODO Auto-generated method stub
		return casteRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Caste not found wiht id" + id));
	}

	@Override
	public void delteCasteById(int id) {
		
		try {
			
			// TODO Auto-generated method stub
			casteRepository.deleteById(id);
			
		} catch (Exception e) {
			
			throw new DataBaseException("Failed to delete caste due to database error");
		}
	}

}
