package com.example.MatrimonyManagement.dto;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ReligionDTO {
	private String name;
	private LocalDateTime createdat;
	private LocalDateTime updatedat;
}
