package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Admin;
import com.example.MatrimonyManagement.repositories.AdminRepository;
import com.example.MatrimonyManagement.service.AdminSerivce;

@Service
public class AdminIMPL implements AdminSerivce {

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public Admin saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteAdminById(int id) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(id);
	}

}
