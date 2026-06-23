package com.example.MatrimonyManagement.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.dto.BioDataDto;
import com.example.MatrimonyManagement.entities.CustomerProfile;
import com.example.MatrimonyManagement.repositories.CustomerProfileRepository;
import com.example.MatrimonyManagement.repositories.CustomerRepository;
import com.example.MatrimonyManagement.security.PdfGeneratorutil;
import com.example.MatrimonyManagement.service.BioDataService;

@Service
public class BioDataServiceIMPL implements BioDataService {

	   
	
	@Autowired
	private CustomerProfileRepository  customerProfileRepository;
	
	@Autowired
	private PdfGeneratorutil pdfGeneratorutil;
	
	@Override
	public byte[] generateBioData(BioDataDto bioDataDto) {
		
		CustomerProfile customerProfile = customerProfileRepository.findById(bioDataDto.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Profile not Found"));
		
		try {
			
			return pdfGeneratorutil.generateBiodata(customerProfile);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("Pdf Generation Failed", e);
		}
		
		
	}

}
