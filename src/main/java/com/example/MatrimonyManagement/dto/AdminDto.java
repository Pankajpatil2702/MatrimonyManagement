package com.example.MatrimonyManagement.dto;

import jakarta.validation.constraints.Email;
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
public class AdminDto {
	
	@NotBlank(message = "Name is required")
	@Size(min = 3 , max = 50 , message = "Name must be between 3 to 50 characters")
	private String name;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Enter valid email")
	private String email;
	
	@NotBlank(message = "Password is required")
	private String password;
	
	private String token;
	
//	private String role;
	

}
