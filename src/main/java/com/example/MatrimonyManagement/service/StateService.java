
package com.example.MatrimonyManagement.service;

import java.util.List;

import com.example.MatrimonyManagement.entities.State;

public interface StateService {
	
	State saveState(State state);
	
	List<State> findAllState();
	
	State getStateById(int id);
	
	void deleteStateById(int id);

}
