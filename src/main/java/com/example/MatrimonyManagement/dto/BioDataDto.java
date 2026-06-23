package com.example.MatrimonyManagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BioDataDto {

	@NotNull(message = "customer id is required for biodata")
	private int customerId;
}
