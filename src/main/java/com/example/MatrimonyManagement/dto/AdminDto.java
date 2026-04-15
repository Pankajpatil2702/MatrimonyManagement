package com.example.MatrimonyManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdminDto {
	
	private String name;
	private String email;
	private String password;
	private String role;
	

}
