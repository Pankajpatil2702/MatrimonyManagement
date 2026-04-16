package com.example.MatrimonyManagement.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.State;
import com.example.MatrimonyManagement.repositories.StateRepository;
import com.example.MatrimonyManagement.service.StateService;

@Service
public class StateIMPL implements StateService {

	@Autowired
	private StateRepository stateRepository;
	
	
	@Override
	public State saveState(State state) {
		// TODO Auto-generated method stub
		return stateRepository.save(state);
	}

	@Override
	public List<State> findAllState() {
		// TODO Auto-generated method stub
		return stateRepository.findAll();
	}

	@Override
	public State getStateById(int id) {
		// TODO Auto-generated method stub
		return stateRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteStateById(int id) {
		// TODO Auto-generated method stub
		stateRepository.deleteById(id);
	}

}
