package com.example.MatrimonyManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MatrimonyManagement.entities.Taluka;

@Repository
public interface TalukaRepository extends JpaRepository<Taluka, Integer> {

}
