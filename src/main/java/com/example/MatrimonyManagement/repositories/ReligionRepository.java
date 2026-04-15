package com.example.MatrimonyManagement.repositories;

import java.security.Identity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MatrimonyManagement.entities.Religion;
@Repository
public interface ReligionRepository extends JpaRepository<Religion, Integer> {

}
