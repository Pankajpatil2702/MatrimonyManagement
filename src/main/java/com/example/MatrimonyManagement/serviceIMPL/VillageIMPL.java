package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Village;
import com.example.MatrimonyManagement.exception.DataBaseException;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.VillageRepository;
import com.example.MatrimonyManagement.service.VillageService;

@Service
public class VillageIMPL implements VillageService {

    @Autowired
    private VillageRepository villageRepository;

    @Override
    public Village saveVillage(Village village) {

        try {

            return villageRepository.save(village);

        } catch (Exception e) {

            throw new DataBaseException("Failed to save village due to database error");
        }
    }

    @Override
    public List<Village> getAllVillage() {

        try {

            return villageRepository.findAll();

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch villages due to database error");
        }
    }

    @Override
    public Village getVillageById(int id) {

        try {

            return villageRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Village not found with id " + id));

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch village due to database error");
        }
    }

    @Override
    public void deleteVillageById(int id) {

        try {

            Village village = villageRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Village not found with id " + id));

            villageRepository.delete(village);

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to delete village due to database error");
        }
    }

}