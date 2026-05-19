package com.example.MatrimonyManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	
	@Pattern(regexp = "^[6-9][0-9]{9}$", message = "Enter valid 10 digit mobile number")
	private long phoneNo;
	
	@NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be 18 or above")
	private int age;
	
	@NotBlank(message = "Gender is required")
	private String gender;
	
	@NotNull(message = "Height is required")
    @Min(value = 1, message = "Height must be greater than 0")
	private int height;
	
	@NotBlank(message = "Education is required")
	private String education;
	
	@NotBlank(message = "Occupation is required")
	private String occupation;
	
	@NotNull(message = "Income is required")
    @Min(value = 1, message = "Income must be greater than 0")
	private long income;
	
	@NotBlank(message = "Marital Status is required")
	private String materialStatus;
	
	@NotBlank(message = "Address is required")
    @Size(min = 5, max = 200, message = "Address must be between 5 to 200 characters")
	private String address;
	
	private String token;
	
//	private LocalDateTime createdAt;  
//	private LocalDateTime updatedAt;
	
	@Min(value = 1, message = "Consultancy Id must be greater than 0")
    private int consultancyId;

    @Min(value = 1, message = "Religion Id must be greater than 0")
    private int religionId;

    @Min(value = 1, message = "Caste Id must be greater than 0")
    private int casteId;

    @Min(value = 1, message = "SubCaste Id must be greater than 0")
    private int subCasteId;

    @Min(value = 1, message = "District Id must be greater than 0")
    private int districtId;

    @Min(value = 1, message = "Taluka Id must be greater than 0")
    private int talukaId;

    @Min(value = 1, message = "Village Id must be greater than 0")
    private int villageId;

}
