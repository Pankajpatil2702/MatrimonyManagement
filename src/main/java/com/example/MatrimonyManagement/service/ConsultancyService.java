package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.Consultancy;

public interface ConsultancyService {
	
	 Consultancy saveConsultancy(Consultancy consultancy);
	 
	 List<Consultancy> findAllConsultancies();
	 
	 Consultancy getConsultancyById(int id);
	 
	 void deleteConsultancy(int id);

}
