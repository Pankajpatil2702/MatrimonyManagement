package com.example.MatrimonyManagement.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "profileinterests")
public class ProfileInterest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "from_cumstomer_id")
	@JsonIgnoreProperties(value = "from_customer_id" , allowSetters = true)
	private Customer fromCustomer;
	
	@ManyToOne
	@JoinColumn(name = "to_customer_id")
	@JsonIgnoreProperties(value = "to_customer_id" , allowSetters = true)
	private Customer toCustomer;  
	
	
	
	
	
}
