package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class ReligionDTO {
	
	@NotBlank(message = "Name is required")
	private String name;
	
//	private LocalDateTime createdat;
//	private LocalDateTime updatedat;
}
