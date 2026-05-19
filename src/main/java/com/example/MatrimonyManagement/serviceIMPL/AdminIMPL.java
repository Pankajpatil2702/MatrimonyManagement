package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Admin;
import com.example.MatrimonyManagement.exception.DataBaseException;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.AdminRepository;
import com.example.MatrimonyManagement.service.AdminSerivce;

@Service
public class AdminIMPL implements AdminSerivce {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin saveAdmin(Admin admin) {
		
		try {
			
			// TODO Auto-generated method stub
			return adminRepository.save(admin);
			
		} catch (Exception e) {

			throw new DataBaseException("Failed to save admin due to database error");
		}
	}

	@Override
	public List<Admin> getAllAdmin() {
		
		try {
			
			// TODO Auto-generated method stub
			return adminRepository.findAll();
			
		} catch (Exception e) {
			
			throw new DataBaseException("Failed to find admin due to database error");
			
		}
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Admin not found with is + " + id));
	}

	@Override
	public void deleteAdminById(int id) {
		
		try {
			
			// TODO Auto-generated method stub
			adminRepository.deleteById(id);
			
		} catch (Exception e) {
			
			throw new DataBaseException("Filed to delete admin due to database error");
		}
	}

}
