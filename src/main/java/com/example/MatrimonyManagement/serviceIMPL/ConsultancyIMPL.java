package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Consultancy;
import com.example.MatrimonyManagement.exception.DataBaseException;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.ConsultancyRepository;
import com.example.MatrimonyManagement.service.ConsultancyService;

@Service
public class ConsultancyIMPL implements ConsultancyService {

	@Autowired
	private ConsultancyRepository consultancyRepository;
	
	@Override
	public Consultancy saveConsultancy(Consultancy consultancy) {
		
		try {
			
			// TODO Auto-generated method stub
			return consultancyRepository.save(consultancy);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new DataBaseException("Failed to save cosultancy due to database error");
			
		}
	}

	@Override
	public List<Consultancy> findAllConsultancies() {
		
		try {
			
			// TODO Auto-generated method stub
			return consultancyRepository.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			throw new DataBaseException("Failed to find consultancy due to datbase error");
			
		}
	}

	@Override
	public Consultancy getConsultancyById(int id) {
		// TODO Auto-generated method stub
		return consultancyRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("consultancy not found with id" + id));
	}

	@Override
	public void deleteConsultancy(int id) {
		
		try {
			
			// TODO Auto-generated method stub
			consultancyRepository.deleteById(id);
			
		} catch (Exception e) {
			
			throw new DataBaseException("Failed to delete consultacny due to database error");
			
		}

	}

}
