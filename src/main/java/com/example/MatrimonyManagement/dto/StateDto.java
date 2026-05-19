package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StateDto {

	@NotBlank(message = "State name is required")
	private String name;
	
//	private LocalDateTime createdAt;
//	private LocalDateTime updateDateTime;
	
}
