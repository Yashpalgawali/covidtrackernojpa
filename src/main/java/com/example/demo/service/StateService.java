package com.example.demo.service;

import java.util.List;

import com.example.demo.models.State;

public interface StateService {

	public boolean isSaveState(State state); 
	
	public List<State> getAllStates();
	
	public State getStateById(String id);
	
	public int updateState(State state);
	
}