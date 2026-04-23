package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.District;
import com.example.MatrimonyManagement.repositories.DistrictRepository;
import com.example.MatrimonyManagement.service.DistrictService;

@Service
public class DistrictIMPL implements DistrictService {

	@Autowired
	private DistrictRepository districtRepository;
	
	@Override
	public District saveDistrict(District district) {
		// TODO Auto-generated method stub
		return districtRepository.save(district);
	}

	@Override
	public List<District> findAllDistrict() {
		// TODO Auto-generated method stub
		return districtRepository.findAll();
	}

	@Override
	public District findDistrictById(int id) {
		// TODO Auto-generated method stub
		return districtRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteDistrictById(int id) {
		// TODO Auto-generated method stub
		districtRepository.deleteById(id);
	}

}
