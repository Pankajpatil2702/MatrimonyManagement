package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DistrictDto {

	@NotBlank(message = "district name is required")
	private String districtName;
	
//	private LocalDateTime createdAt;
//	private LocalDateTime updatedAt;
	
	@Min(value = 1, message = "Consultancy Id must be greater than 0")
	private int stateId;
	
}
