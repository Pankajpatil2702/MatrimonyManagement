package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.State;
import com.example.MatrimonyManagement.exception.DataBaseException;
import com.example.MatrimonyManagement.exception.ResourceNotFoundException;
import com.example.MatrimonyManagement.repositories.StateRepository;
import com.example.MatrimonyManagement.service.StateService;

@Service
public class StateIMPL implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public State saveState(State state) {

        try {

            return stateRepository.save(state);

        } catch (Exception e) {

            throw new DataBaseException("Failed to save state due to database error");
        }
    }

    @Override
    public List<State> findAllState() {

        try {

            return stateRepository.findAll();

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch states due to database error");
        }
    }

    @Override
    public State getStateById(int id) {

        try {

            return stateRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("State not found with id " + id));

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to fetch state due to database error");
        }
    }

    @Override
    public void deleteStateById(int id) {

        try {

            State state = stateRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("State not found with id " + id));

            stateRepository.delete(state);

        } catch (ResourceNotFoundException e) {

            throw e;

        } catch (Exception e) {

            throw new DataBaseException("Failed to delete state due to database error");
        }
    }

}