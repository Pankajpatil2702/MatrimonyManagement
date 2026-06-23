package com.example.MatrimonyManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MatrimonyManagement.entities.CustomerProfile;


@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Integer> {

}
