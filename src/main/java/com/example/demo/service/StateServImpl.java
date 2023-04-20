package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.State;
import com.example.demo.repository.StateRepo;

@Service("stateserv")
public class StateServImpl implements StateService {

	@Autowired
	StateRepo staterepo;
	
	@Override
	public boolean isSaveState(State state) {
		// TODO Auto-generated method stub
		return staterepo.isSaveState(state);
	}

	@Override
	public List<State> getAllStates() {
		// TODO Auto-generated method stub
		return staterepo.getAllStates();
	}

	@Override
	public State getStateById(String id) {
		// TODO Auto-generated method stub
		return staterepo.getStateById(id);
	}

	@Override
	public int updateState(State state) {
		// TODO Auto-generated method stub
		return staterepo.updateState(state);
	}

}
