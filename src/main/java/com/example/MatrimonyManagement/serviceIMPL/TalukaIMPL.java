package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.Taluka;
import com.example.MatrimonyManagement.exception.DataBaseException;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.TalukaRepository;
import com.example.MatrimonyManagement.service.TalukaService;

@Service
public class TalukaIMPL implements TalukaService {

    @Autowired
    private TalukaRepository talukaRepository;

    @Override
    public Taluka saveTaluka(Taluka taluka) {

        try {

            return talukaRepository.save(taluka);

        } catch (Exception e) {

            throw new DataBaseException("Failed to save taluka due to database error");
        }
    }

    @Override
    public List<Taluka> findAllTaluka() {

        try {

            return talukaRepository.findAll();

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch talukas due to database error");
        }
    }

    @Override
    public Taluka findTalukaById(int id) {

        try {

            return talukaRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Taluka not found with id " + id));

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch taluka due to database error");
        }
    }

    @Override
    public void deleteTalukaById(int id) {

        try {

            Taluka taluka = talukaRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Taluka not found with id " + id));

            talukaRepository.delete(taluka);

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to delete taluka due to database error");
        }
    }

}