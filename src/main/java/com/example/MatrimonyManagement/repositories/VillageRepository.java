package com.example.MatrimonyManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MatrimonyManagement.entities.Village;

@Repository
public interface VillageRepository extends JpaRepository<Village, Integer> {

}
