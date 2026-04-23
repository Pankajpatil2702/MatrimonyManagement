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

import com.example.MatrimonyManagement.dto.CustomerDto;
import com.example.MatrimonyManagement.entities.Caste;
import com.example.MatrimonyManagement.entities.Consultancy;
import com.example.MatrimonyManagement.entities.Customer;
import com.example.MatrimonyManagement.entities.District;
import com.example.MatrimonyManagement.entities.Religion;
import com.example.MatrimonyManagement.entities.SubCaste;
import com.example.MatrimonyManagement.entities.Taluka;
import com.example.MatrimonyManagement.entities.Village;
import com.example.MatrimonyManagement.service.CasteService;
import com.example.MatrimonyManagement.service.ConsultancyService;
import com.example.MatrimonyManagement.service.CustomerService;
import com.example.MatrimonyManagement.service.DistrictService;
import com.example.MatrimonyManagement.service.ReligionService;
import com.example.MatrimonyManagement.service.SubCasteService;
import com.example.MatrimonyManagement.service.TalukaService;
import com.example.MatrimonyManagement.service.VillageService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ConsultancyService consultancyService;
	
	@Autowired
	private ReligionService religionService;
	
	@Autowired
	private SubCasteService subCasteService;
	
	@Autowired
	private CasteService casteService;
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private TalukaService talukaService;
	
	@Autowired
	private VillageService villageService;
	
	
	
	@PostMapping("/")
	public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDto customerDto){
		
		Customer customer = new Customer();
		customer.setName(customerDto.getName());
		customer.setEducation(customerDto.getEducation());
		customer.setPhoneNo(customerDto.getPhoneNo());
		customer.setAge(customerDto.getAge());
		customer.setGender(customerDto.getGender());
		customer.setHeight(customerDto.getHeight());
		customer.setEducation(customerDto.getEducation());
		customer.setOccupation(customerDto.getOccupation());
		customer.setIncome(customerDto.getIncome());
		customer.setMaterialStatus(customerDto.getMaterialStatus());
		customer.setAddress(customerDto.getAddress());
		customer.setCreatedAt(LocalDateTime.now());
		customer.setUpdatedAt(LocalDateTime.now());
		
		Consultancy consultancy = consultancyService.getConsultancyById(customerDto.getConsultancyId());
		
		Religion religion = religionService.getReligionById(customerDto.getReligionId());
		
		Caste caste = casteService.findCasteById(customerDto.getCasteId());
		
		SubCaste subCaste = subCasteService.findSubCasteById(customerDto.getSubCasteId());
		
		District district = districtService.findDistrictById(customerDto.getDistrictId());
		
		Taluka taluka = talukaService.findTalukaById(customerDto.getTalukaId());
		
		Village village = villageService.getVillageById(customerDto.getVillageId());
		
		
		if(consultancy == null  || religion == null || caste == null || subCaste == null || district == null || village == null  || taluka == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		customer.setConsultancyId(consultancy);
		customer.setReligionId(religion);
		customer.setSubCasteId(subCaste);
		customer.setDistrictId(district);
		customer.setVillageId(village);
		
		Customer saveCustomer = customerService.saveCustomer(customer);
		
		return new ResponseEntity<>(saveCustomer, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		
		List<Customer> customer = customerService.getAllCustomer();
		
		if(customer == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
		
		Customer customer = customerService.getCustomerById(id);
		
		if(customer == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable("id") int id, @RequestBody CustomerDto customerDto){
		
		Customer customer = customerService.getCustomerById(id);
		
		customer.setName(customerDto.getName());
		customer.setEducation(customerDto.getEducation());
		customer.setPhoneNo(customerDto.getPhoneNo());
		customer.setAge(customerDto.getAge());
		customer.setGender(customerDto.getGender());
		customer.setHeight(customerDto.getHeight());
		customer.setEducation(customerDto.getEducation());
		customer.setOccupation(customerDto.getOccupation());
		customer.setIncome(customerDto.getIncome());
		customer.setMaterialStatus(customerDto.getMaterialStatus());
		customer.setAddress(customerDto.getAddress());
		customer.setCreatedAt(LocalDateTime.now());
		customer.setUpdatedAt(LocalDateTime.now());
		
		Consultancy consultancy = consultancyService.getConsultancyById(customerDto.getConsultancyId());
		
		Religion religion = religionService.getReligionById(customerDto.getReligionId());
		
		Caste caste = casteService.findCasteById(customerDto.getCasteId());
		
		SubCaste subCaste = subCasteService.findSubCasteById(customerDto.getSubCasteId());
		
		District district = districtService.findDistrictById(customerDto.getDistrictId());
		
		Taluka taluka = talukaService.findTalukaById(customerDto.getTalukaId());
		
		Village village = villageService.getVillageById(customerDto.getVillageId());
		
		
		if(consultancy == null  || religion == null || caste == null || subCaste == null || district == null || village == null  || taluka == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		customer.setConsultancyId(consultancy);
		customer.setReligionId(religion);
		customer.setSubCasteId(subCaste);
		customer.setDistrictId(district);
		customer.setVillageId(village);
		
		Customer updateCustomer = customerService.saveCustomer(customer);
		
		return new ResponseEntity<>(updateCustomer , HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") int id){
		
		Customer customer = customerService.getCustomerById(id);
		
		if(customer == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		customerService.deleteCustomerById(id);
		
		return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY); 
		
	}
	
	
	
}
