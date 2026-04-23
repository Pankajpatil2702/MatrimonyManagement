package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.ConsultancyUser;

public interface ConsultancyUserService {

	ConsultancyUser saveConsultancyUser(ConsultancyUser consultancyUser);
	
	List<ConsultancyUser> getAllConsultancyUser();
	
	ConsultancyUser getConsultancyUserById(int id);
	
	void deleteConsultancyUserById(int id);

}
