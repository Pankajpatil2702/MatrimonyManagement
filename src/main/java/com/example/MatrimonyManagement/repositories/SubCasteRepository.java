package com.example.MatrimonyManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MatrimonyManagement.entities.SubCaste;

@Repository
public interface SubCasteRepository extends JpaRepository<SubCaste, Integer> {

}
