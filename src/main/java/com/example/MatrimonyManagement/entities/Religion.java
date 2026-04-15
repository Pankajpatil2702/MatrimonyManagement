package com.example.MatrimonyManagement.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name= "religions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Religion {
	
	private int id;
	private String name;
	private LocalDateTime createdat;
	private LocalDateTime updatedat;

}
