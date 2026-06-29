package com.example.MatrimonyManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailRequest {
	
	private String email;
	
//	private String to;
	
	private String subject;
	
	private String message;

}
