package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Consultancy;
import com.example.MatrimonyManagement.repositories.ConsultancyRepository;
import com.example.MatrimonyManagement.service.ConsultancyService;

@Service
public class ConsultancyIMPL implements ConsultancyService {

	@Autowired
	private ConsultancyRepository consultancyRepository;
	
	@Override
	public Consultancy saveConsultancy(Consultancy consultancy) {
		// TODO Auto-generated method stub
		return consultancyRepository.save(consultancy);
	}

	@Override
	public List<Consultancy> findAllConsultancies() {
		// TODO Auto-generated method stub
		return consultancyRepository.findAll();
	}

	@Override
	public Consultancy getConsultancyById(int id) {
		// TODO Auto-generated method stub
		return consultancyRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteConsultancy(int id) {
		// TODO Auto-generated method stub
		consultancyRepository.deleteById(id);

	}

}
