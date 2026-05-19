package com.example.MatrimonyManagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MatrimonyManagement.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Boolean existsByEmail(String email);
	
	Optional<Admin> findByEmail(String email);
	
	
}
