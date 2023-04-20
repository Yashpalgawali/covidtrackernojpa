package com.example.demo.repository;

import java.util.List;

import com.example.demo.models.State;

public interface StateRepo {

	public boolean isSaveState(State state);
	
	public List<State> getAllStates();
	
	public int updateState(State state);
	
	public State getStateById(String id);
	
}
