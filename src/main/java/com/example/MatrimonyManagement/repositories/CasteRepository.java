package com.example.MatrimonyManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MatrimonyManagement.entities.Caste;

@Repository
public interface CasteRepository extends JpaRepository<Caste, Integer> {

}
