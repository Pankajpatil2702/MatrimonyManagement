package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.SubCaste;
import com.example.MatrimonyManagement.exception.DataBaseException;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.SubCasteRepository;
import com.example.MatrimonyManagement.service.SubCasteService;

@Service
public class SubCasteIMPL implements SubCasteService {

    @Autowired
    private SubCasteRepository subCasteRepository;

    @Override
    public SubCaste saveSubCaste(SubCaste caste) {

        try {

            return subCasteRepository.save(caste);

        } catch (Exception e) {

            throw new DataBaseException("Failed to save sub caste due to database error");
        }
    }

    @Override
    public List<SubCaste> findAllSubCaste() {

        try {

            return subCasteRepository.findAll();

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch sub castes due to database error");
        }
    }

    @Override
    public SubCaste findSubCasteById(int id) {

        try {

            return subCasteRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Sub caste not found with id " + id));

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch sub caste due to database error");
        }
    }

    @Override
    public void deleteSubCasteById(int id) {

        try {

            SubCaste subCaste = subCasteRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Sub caste not found with id " + id));

            subCasteRepository.delete(subCaste);

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to delete sub caste due to database error");
        }
    }

}