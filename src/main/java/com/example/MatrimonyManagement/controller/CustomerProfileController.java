package com.example.MatrimonyManagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MatrimonyManagement.dto.CustomerProfileDto;
import com.example.MatrimonyManagement.entities.Caste;
import com.example.MatrimonyManagement.entities.Customer;
import com.example.MatrimonyManagement.entities.CustomerProfile;
import com.example.MatrimonyManagement.entities.District;
import com.example.MatrimonyManagement.entities.Religion;
import com.example.MatrimonyManagement.entities.State;
import com.example.MatrimonyManagement.entities.SubCaste;
import com.example.MatrimonyManagement.entities.Taluka;
import com.example.MatrimonyManagement.entities.Village;
import com.example.MatrimonyManagement.service.CasteService;
import com.example.MatrimonyManagement.service.CustomerProfileService;
import com.example.MatrimonyManagement.service.CustomerService;
import com.example.MatrimonyManagement.service.DistrictService;
import com.example.MatrimonyManagement.service.ReligionService;
import com.example.MatrimonyManagement.service.StateService;
import com.example.MatrimonyManagement.service.SubCasteService;
import com.example.MatrimonyManagement.service.TalukaService;
import com.example.MatrimonyManagement.service.VillageService;

@RestController
@RequestMapping("/customerprofile")
public class CustomerProfileController {

	@Autowired
	private CustomerProfileService customerProfileService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private TalukaService talukaService;
	
	@Autowired
	private VillageService villageService;
	
	@Autowired
	private ReligionService religionService;
	
	@Autowired
	private CasteService casteService;
	
	@Autowired
	private SubCasteService subCasteService;
	
	
	@PostMapping("/register")
	public ResponseEntity<CustomerProfile> saveCustomerProfileData(@RequestBody CustomerProfileDto customerProfileDto){
		
		CustomerProfile customerProfile = new CustomerProfile();
		
		customerProfile.setCustomerName(customerProfileDto.getCustomerName());
		customerProfile.setAge(customerProfileDto.getAge());
		customerProfile.setGender(customerProfileDto.getGender());
		customerProfile.setEducation(customerProfileDto.getEducation());
		customerProfile.setOccupation(customerProfileDto.getOccupation());
		customerProfile.setProfilePhoto(customerProfileDto.getProfilePhoto());
		customerProfile.setMaterialStatus(customerProfileDto.getMaterialStatus());
		customerProfile.setBio(customerProfileDto.getBio());
		customerProfile.setCity(customerProfileDto.getCity());
		customerProfile.setHeight(customerProfileDto.getHeight());
		customerProfile.setIncome(customerProfileDto.getIncome());
		customerProfile.setPhoneNo(customerProfileDto.getPhoneNo());
		customerProfile.setCity(customerProfileDto.getCity());	
		customerProfile.setCreatedAt(LocalDateTime.now());
		customerProfile.setUpdatedAt(LocalDateTime.now());
		
		Customer customer = customerService.getCustomerById(customerProfileDto.getCustomerId());
		
		State state = stateService.getStateById(customerProfileDto.getStateId());
		
		District district = districtService.findDistrictById(customerProfileDto.getDistrictId());
		
		Taluka taluka = talukaService.findTalukaById(customerProfileDto.getTalukaId());
		
		Village village = villageService.getVillageById(customerProfileDto.getVillageId());
		
		Religion religion = religionService.getReligionById(customerProfileDto.getReligionId());
		
		Caste caste = casteService.findCasteById(customerProfileDto.getCasteId());
		
		SubCaste subCaste = subCasteService.findSubCasteById(customerProfileDto.getSubCasteId());
		
		customerProfile.setCustomerid(customer);
		customerProfile.setStateId(state);
		customerProfile.setDistrictId(district);
		customerProfile.setTalukaId(taluka);
		customerProfile.setVillageId(village);
		customerProfile.setReligionId(religion);
		customerProfile.setCasteId(caste);
		customerProfile.setSubCasteId(subCaste);
		
		CustomerProfile saveCustomerProfile = customerProfileService.saveCustomerProfile(customerProfile);
		
		return new ResponseEntity<>(saveCustomerProfile, HttpStatus.CREATED);
				
				
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CustomerProfile>> getAllCustomerPrpfileData(){
		
		List<CustomerProfile> customerProfile = customerProfileService.getAllCustomerProfile();
		
		if(customerProfile == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(customerProfile , HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerProfile> getCustomerProfileById(@PathVariable("id") int id){
		
		CustomerProfile  customerProfile  = customerProfileService.getCustomerProfileById(id);
		
		if(customerProfile == null) {
			
			return new ResponseEntity<>(customerProfile , HttpStatus.OK);
			
		}
		
		return new ResponseEntity<>(customerProfile, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CustomerProfile> updateCustomerProfileById(@PathVariable("id") int id , @RequestBody CustomerProfileDto customerProfileDto){
		
		CustomerProfile customerProfile = new CustomerProfile();
		
		customerProfile.setCustomerName(customerProfileDto.getCustomerName());
		customerProfile.setAge(customerProfileDto.getAge());
		customerProfile.setGender(customerProfileDto.getGender());
		customerProfile.setEducation(customerProfileDto.getEducation());
		customerProfile.setOccupation(customerProfileDto.getOccupation());
		customerProfile.setProfilePhoto(customerProfileDto.getProfilePhoto());
		customerProfile.setMaterialStatus(customerProfileDto.getMaterialStatus());
		customerProfile.setBio(customerProfileDto.getBio());
		customerProfile.setCity(customerProfileDto.getCity());
		customerProfile.setHeight(customerProfileDto.getHeight());
		customerProfile.setIncome(customerProfileDto.getIncome());
		customerProfile.setPhoneNo(customerProfileDto.getPhoneNo());
		customerProfile.setCity(customerProfileDto.getCity());	
		customerProfile.setCreatedAt(LocalDateTime.now());
		customerProfile.setUpdatedAt(LocalDateTime.now());
		
		Customer customer = customerService.getCustomerById(customerProfileDto.getCustomerId());
		
		State state = stateService.getStateById(customerProfileDto.getStateId());
		
		District district = districtService.findDistrictById(customerProfileDto.getDistrictId());
		
		Taluka taluka = talukaService.findTalukaById(customerProfileDto.getTalukaId());
		
		Village village = villageService.getVillageById(customerProfileDto.getVillageId());
		
		Religion religion = religionService.getReligionById(customerProfileDto.getReligionId());
		
		Caste caste = casteService.findCasteById(customerProfileDto.getCasteId());
		
		SubCaste subCaste = subCasteService.findSubCasteById(customerProfileDto.getSubCasteId());
		
		customerProfile.setCustomerid(customer);
		customerProfile.setStateId(state);
		customerProfile.setDistrictId(district);
		customerProfile.setTalukaId(taluka);
		customerProfile.setVillageId(village);
		customerProfile.setReligionId(religion);
		customerProfile.setCasteId(caste);
		customerProfile.setSubCasteId(subCaste);
		
		if(customer == null || state == null || district == null || taluka == null || village == null ||
					religion == null || caste == null || subCaste == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		CustomerProfile updateCustomerProfile =  customerProfileService.saveCustomerProfile(customerProfile);
		
		return new ResponseEntity<>(updateCustomerProfile , HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomerProfileById(@PathVariable("id") int id){
		
		CustomerProfile customerProfile = customerProfileService.getCustomerProfileById(id);
		
		if(customerProfile == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
		
		customerProfileService.deleteCustomerProfileById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		
	}
	
	
	
	
	
	
	
	
	
 	
}
