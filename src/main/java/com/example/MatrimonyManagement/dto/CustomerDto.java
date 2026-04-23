package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
	
	private String name;
	private String email;
	private long phoneNo;
	private int age;
	private String gender;
	private int height;
	private String education;
	private String occupation;
	private long income;
	private String materialStatus;
	private String address;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	private int consultancyId;
	
	private int religionId;
	
	private int casteId;
	
	private int subCasteId;
	
	private int districtId;
	
	private int talukaId;
	
	private int villageId;

}
