package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.ProfileInterest;

public interface ProfileInterestService {
	
	ProfileInterest saveProfileInterest(ProfileInterest profileInterest);
	
	List<ProfileInterest> getAllProfileInterest();
	
	ProfileInterest gertProfileInterestById(int id);
	
	void  deleteProfileInterestById(int id);

}
