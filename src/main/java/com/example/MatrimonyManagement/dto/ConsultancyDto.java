package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConsultancyDto {

	@NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 to 50 characters")
	private String name;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Enter valid email")
	private String email;
	
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Enter valid 10 digit mobile number")
	private long phoneNo;
	
	@NotBlank(message = "Address is required")
    @Size(min = 5, max = 200, message = "Address must be between 5 to 200 characters")
	private String address;
	
//	private LocalDateTime createdAt;
//	private LocalDateTime updatedAt;

	
	
	
}
