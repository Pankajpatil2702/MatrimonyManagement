 package com.example.MatrimonyManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class CustomerDto {
	
	@NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 to 50 characters")
	private String name;
	
	@NotBlank(message = "Email is required")
    @Email(message = "Enter valid email")
	private String email;
	
	@NotBlank(message = "password is required")
	private String password;
	
	@Min(value = 1000000000L, message = "Phone number must be 10 digits")
	@Max(value = 9999999999L, message = "Phone number must be 10 digits")
	private long phoneNo;
	
	private Boolean isActive  = true;
	
	private Boolean isBlocked = false;
	
}
