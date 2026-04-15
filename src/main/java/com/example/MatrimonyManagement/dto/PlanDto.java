package com.example.MatrimonyManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlanDto {

	private String name;
	private float price;
	private String duration;
	private String description;	
}
