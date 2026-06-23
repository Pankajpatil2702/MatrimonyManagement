package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

import com.example.MatrimonyManagement.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerProfileDto {

	private int customerId;

    private String customerName;

    private Integer age;

    private String gender;

    private String education;

    private String occupation;
    
    private String profilePhoto;

    private String materialStatus;

    private String bio;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    
    private String height;

	private Double income;
    
	private String phoneNo;
	
	private String city;
	
	
	private int religionId;
	
	private int casteId;
	
	private int subCasteId;
	
	private int stateId;
	
	private int districtId;
	
	private int talukaId;
	
	private int villageId;
	
	
	
	
	
	
	
	
}
