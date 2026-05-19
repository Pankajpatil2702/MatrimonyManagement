package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Plan;
import com.example.MatrimonyManagement.exception.DataBaseException;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.PlanRepository;
import com.example.MatrimonyManagement.service.PlanService;

@Service
public class PlanIMPL implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public Plan savePlan(Plan plan) {

        try {

            return planRepository.save(plan);

        } catch (Exception e) {

            throw new DataBaseException("Failed to save plan due to database error");
        }
    }

    @Override
    public List<Plan> getPlan() {

        try {

            return planRepository.findAll();

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch plans due to database error");
        }
    }

    @Override
    public Plan getPlanById(int id) {

        try {

            return planRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Plan not found with id " + id));

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch plan due to database error");
        }
    }

    @Override
    public void deletePlanById(int id) {

        try {

            Plan plan = planRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Plan not found with id " + id));

            planRepository.delete(plan);

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to delete plan due to database error");
        }
    }

}