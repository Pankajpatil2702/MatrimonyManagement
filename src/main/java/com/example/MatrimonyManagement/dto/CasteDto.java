package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CasteDto {
	
	@NotBlank(message = "Caste name is required")
    @Size(min = 2, max = 50, message = "Caste name must be between 2 to 50 characters")
	private String casteName;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@NotNull(message = "Religion Id is required")
    @Min(value = 1, message = "Religion Id must be greater than 0")
	private int religionId;

}
