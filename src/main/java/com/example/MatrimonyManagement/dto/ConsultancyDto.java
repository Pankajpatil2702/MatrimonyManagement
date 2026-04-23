package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConsultancyDto {

	private String name;
	private String email;
	private long phoneNo;
	private String address;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	
	
}
