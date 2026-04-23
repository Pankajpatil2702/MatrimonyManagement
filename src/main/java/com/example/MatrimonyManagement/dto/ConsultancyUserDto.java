package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

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
public class ConsultancyUserDto {
	
	private String name;
	private String email;
	private String password;
	private String role;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	private int consultancyId;
}
