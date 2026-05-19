package com.example.MatrimonyManagement.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlanDto {

	@NotBlank(message = "Plan name is required")
	@Size(min = 2, max = 50, message = "Plan name must be between 2 to 50 characters")
	private String name;
	
	@DecimalMin(value = "1.0", message = "Price must be greater than 0")
	private float price;
	
	@NotBlank(message = "Duration is required")
	private String duration;
	
	@NotBlank(message = "Description is required")
    @Size(min = 5, max = 200, message = "Description must be between 5 to 200 characters")
	private String description;	
}
