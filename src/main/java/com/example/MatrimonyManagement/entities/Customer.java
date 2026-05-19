package com.example.MatrimonyManagement.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private long phoneNo;
	private int age;
	private String gender;
	private int height;
	private String education;
	private String occupation;
	private long income;
	private String materialStatus;
	private String address;
	private String token;	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "consultancyId")
	@JsonIgnoreProperties(value = "consultancyId", allowSetters = true)
	private Consultancy consultancyId;
	
	@ManyToOne
	@JoinColumn(name = "religionId")
	@JsonIgnoreProperties(value = "religionId" , allowSetters = true)
	private Religion religionId;
	
	@ManyToOne
	@JoinColumn(name = "casteId")
	@JsonIgnoreProperties(value = "casteId", allowSetters = true )
	private Caste casteId;
	
	@ManyToOne
	@JoinColumn(name = "subcasteId")
	@JsonIgnoreProperties(value = "subcasteId", allowSetters = true)
	private SubCaste subCasteId;
	
	@ManyToOne
	@JoinColumn(name = "districtId")
	@JsonIgnoreProperties(value = "districtId", allowSetters = true)
	private District districtId;
	
	@ManyToOne
	@JoinColumn(name = "talukaId")
	@JsonIgnoreProperties(value = "talukaId", allowSetters = true)
	private Taluka talukaId;
	
	@ManyToOne
	@JoinColumn(name = "villageId")
	@JsonIgnoreProperties(value = "villageId" , allowSetters = true)
	private Village villageId;
	
	
	
	
}
