package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class VillageDto {
	
	@NotBlank(message = "Village name is required")
	private String name;
	
//	private LocalDateTime createdAt;
//	private LocalDateTime updatedAt;
	
	@Min(value = 1, message = "To Customer Id must be greater than 0")	
	private int talukaId;

}
