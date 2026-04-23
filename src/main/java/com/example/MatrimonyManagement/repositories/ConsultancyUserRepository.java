package com.example.MatrimonyManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MatrimonyManagement.entities.ConsultancyUser;

@Repository
public interface ConsultancyUserRepository extends JpaRepository<ConsultancyUser, Integer> {

}
