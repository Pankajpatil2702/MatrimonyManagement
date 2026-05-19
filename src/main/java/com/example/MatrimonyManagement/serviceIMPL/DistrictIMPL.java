package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.District;
import com.example.MatrimonyManagement.exception.DataBaseException;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.DistrictRepository;
import com.example.MatrimonyManagement.service.DistrictService;

@Service
public class DistrictIMPL implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public District saveDistrict(District district) {

        try {

            return districtRepository.save(district);

        } catch (Exception e) {

            throw new DataBaseException("Failed to save district due to database error");
        }
    }

    @Override
    public List<District> findAllDistrict() {

        try {

            return districtRepository.findAll();

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch districts due to database error");
        }
    }

    @Override
    public District findDistrictById(int id) {

        try {

            return districtRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("District not found with id " + id));

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch district due to database error");
        }
    }

    @Override
    public void deleteDistrictById(int id) {

        try {

            District district = districtRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("District not found with id " + id));

            districtRepository.delete(district);

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to delete district due to database error");
        }
    }

}