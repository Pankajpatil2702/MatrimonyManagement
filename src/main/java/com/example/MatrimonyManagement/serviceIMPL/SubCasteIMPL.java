package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.SubCaste;
import com.example.MatrimonyManagement.repositories.SubCasteRepository;
import com.example.MatrimonyManagement.service.SubCasteService;

@Service
public class SubCasteIMPL implements SubCasteService {

	@Autowired
	private SubCasteRepository subCasteRepository;
	@Override
	public SubCaste saveSubCaste(SubCaste caste) {
		// TODO Auto-generated method stub
		return subCasteRepository.save(caste);
	}

	@Override
	public List<SubCaste> findAllSubCaste() {
		// TODO Auto-generated method stub
		return subCasteRepository.findAll();
	}

	@Override
	public SubCaste findSubCasteById(int id) {
		// TODO Auto-generated method stub
		return subCasteRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteSubCasteById(int id) {
		// TODO Auto-generated method stub
		subCasteRepository.deleteById(id);
	}

}
