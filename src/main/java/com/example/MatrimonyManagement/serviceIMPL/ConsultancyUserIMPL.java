package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.ConsultancyUser;
import com.example.MatrimonyManagement.repositories.ConsultancyUserRepository;
import com.example.MatrimonyManagement.service.ConsultancyUserService;

@Service
public class ConsultancyUserIMPL implements ConsultancyUserService {

	@Autowired
	private ConsultancyUserRepository consultancyUserRepository;
	@Override
	public ConsultancyUser saveConsultancyUser(ConsultancyUser consultancyUser) {
		// TODO Auto-generated method stub
		return consultancyUserRepository.save(consultancyUser);
	}

	@Override
	public List<ConsultancyUser> getAllConsultancyUser() {
		// TODO Auto-generated method stub
		return consultancyUserRepository.findAll();
	}

	@Override
	public ConsultancyUser getConsultancyUserById(int id) {
		// TODO Auto-generated method stub
		return consultancyUserRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteConsultancyUserById(int id) {
		// TODO Auto-generated method stub
		consultancyUserRepository.deleteById(id);
	}

}
