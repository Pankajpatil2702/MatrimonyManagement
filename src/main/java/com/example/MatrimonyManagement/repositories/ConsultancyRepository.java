package com.example.MatrimonyManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MatrimonyManagement.entities.Consultancy;

@Repository
public interface ConsultancyRepository extends JpaRepository<Consultancy, Integer> {

}
