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
public class TalukaDto {

	@NotBlank(message = "Taluka name is required")
	private String talukaName;
	
//	private LocalDateTime createdAt;
//	private LocalDateTime updatedAt;
	
	@Min(value = 1, message = "To Customer Id must be greater than 0")
	private int talukaId;
}
