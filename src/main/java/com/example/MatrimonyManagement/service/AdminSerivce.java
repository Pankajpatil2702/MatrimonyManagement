package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.Admin;

public interface AdminSerivce {
	
	Admin saveAdmin(Admin admin);
	
	List<Admin> getAllAdmin();
	
	Admin getAdminById(int id);
	
	void deleteAdminById(int id);

}
