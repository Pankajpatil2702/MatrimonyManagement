package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubCasteDto {
	
	private String SubCasteName;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	private int casteId;
	

}
