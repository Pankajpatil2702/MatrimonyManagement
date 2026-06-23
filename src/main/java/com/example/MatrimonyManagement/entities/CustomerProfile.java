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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerProfile {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnoreProperties(value = "customer_id", allowSetters = true)
    private Customer customerid;

    private String customerName;

    private Integer age;

    private String gender;

    private String education;

    private String occupation;
    
    private String profilePhoto;

    private String materialStatus;

    private String bio;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    
    private String height;

	private Double income;
    
	private String phoneNo;
	
	private String city;
	
    @ManyToOne
   	@JoinColumn(name = "religionId")
   	@JsonIgnoreProperties(value = "religionId", allowSetters = true)
    private Religion religionId;
    
    @ManyToOne
   	@JoinColumn(name = "castId")
  	@JsonIgnoreProperties(value = "cast_id", allowSetters = true)
    private Caste casteId;
    
    @ManyToOne
   	@JoinColumn(name = "subcasteId")
   	@JsonIgnoreProperties(value = "subcaste_id", allowSetters = true)
    private SubCaste subCasteId;

    @ManyToOne
	@JoinColumn(name = "state_id")
	@JsonIgnoreProperties(value = "state_id", allowSetters = true)
    private State stateId;

    @ManyToOne	
	@JoinColumn(name = "district_id")
	@JsonIgnoreProperties(value = "district_id", allowSetters = true)
    private District districtId;

    @ManyToOne
	@JoinColumn(name = "talukaId")
	@JsonIgnoreProperties(value = "taluka_id", allowSetters = true)
    private Taluka talukaId;

    @ManyToOne
	@JoinColumn(name = "villageId")
	@JsonIgnoreProperties(value = "village_id", allowSetters = true)
    private Village villageId;
    
  
    
	
}
