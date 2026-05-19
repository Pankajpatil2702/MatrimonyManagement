package com.example.MatrimonyManagement.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "admin",
uniqueConstraints = {
		@UniqueConstraint(columnNames = "email")
	}
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String email;
		private String password;
		private String token;
		@Enumerated(EnumType.STRING)
		private Role role;
		private LocalDateTime createdAt;
		private LocalDateTime updatesAt;

}
