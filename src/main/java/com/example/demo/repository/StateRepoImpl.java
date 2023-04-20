package com.example.demo.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.models.State;

@Repository("staterepo")
public class StateRepoImpl implements StateRepo{

	@Autowired
	JdbcTemplate temp;
	
	
	public String getStateNameByStateId(Long id)
	{
		String sname = temp.queryForObject("select statename from tbl_state where state_id='"+id+"'", String.class);
		
		return sname;
	}
	
	public Long getStateIdByStateName(String sname)
	{
		Long sid = temp.queryForObject("select state_id from tbl_stat where state_name='"+sname+"'", Long.class);
		return sid;
	}
	
	
	@Override
	public boolean isSaveState(State state) {
		// TODO Auto-generated method stub
		
		int res = temp.update("insert into tbl_state values('0',?)",new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				String sname = state.getState_name();
				
				ps.setString(1, sname);
			}
		});
		
		if(res > 0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public List<State> getAllStates() {
		// TODO Auto-generated method stub
		
		List<State> stlist = temp.query("select * from tbl_state", new RowMapper<State>() {

			@Override
			public State mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				State state = new State();
				
				state.setState_id(rs.getLong(1));
				state.setState_name(rs.getString(2));
				return state;
				
			}});
		
		return stlist;
	}

	@Override
	public State getStateById(String id) {
		// TODO Auto-generated method stub
		
		//System.out.println("\n Inside getStateById ID->> "+id+"\n");
	
		State state = temp.queryForObject("select * from tbl_state WHERE state_id='"+id+"'",new BeanPropertyRowMapper<State>(State.class));
		
		return state;
	}

	@Override
	public int updateState(State state) {
		// TODO Auto-generated method stub
		
		
		int res = temp.update("update tbl_state set state_name=? where state_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, state.getState_name());
				ps.setLong(2, state.getState_id());
			}
		});
		
		return res;
	}	
	
	
}
