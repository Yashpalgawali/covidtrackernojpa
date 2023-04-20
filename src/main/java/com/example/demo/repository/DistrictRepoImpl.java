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
import org.springframework.stereotype.Service;

import com.example.demo.models.District;
import com.example.demo.models.State;

@Service("distrepo")
public class DistrictRepoImpl implements DistrictRepo {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public boolean isSaveDistrict(District dist) {
		// TODO Auto-generated method stub
		
		int res = temp.update("insert into tbl_district values('0',?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				String dname = dist.getDist_name();
				//Long did = dist.getDist_id();
				Long sid = dist.getState_id();
				
				ps.setString(1, dname);
				ps.setLong(2, sid);
				
			}
		});
		
		if(res >0){
			return true;	
		}
		else {
			return false;
		}
	}

	
	@Autowired
	StateRepo staterepo;
	
	@Override
	public List<District> getAllDistricts() {
		// TODO Auto-generated method stub
		
		List<District> dlist = temp.query("select tbl_district.*,tbl_state.state_name from tbl_district join tbl_state ON tbl_state.state_id=tbl_district.state_id", new RowMapper<District>(){

			@Override
			public District mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				District dist = new District();
				
				dist.setDist_id(rs.getLong(1));
				dist.setDist_name(rs.getString(2));
				dist.setState_id(rs.getLong(3));
				dist.setState_name(rs.getString(4));
				
				
				return dist;
			}
		});
		
		return dlist;
	}

	@Override
	public District getDistrictByDistId(String id) {
		// TODO Auto-generated method stub
		
		District dist = temp.queryForObject("select * from tbl_district join tbl_state ON tbl_state.state_id=tbl_district.state_id WHERE tbl_district.dist_id='"+id+"'", new BeanPropertyRowMapper<District>(District.class));
		
		return dist;
	}

	@Override
	public int updateDistrict(District dist) {
		// TODO Auto-generated method stub
		
		int res = temp.update("update tbl_district set dist_name=?,state_id=? where dist_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				String dname = dist.getDist_name();
				Long did	 = dist.getDist_id();
				Long sid	 = dist.getState_id();
				
				ps.setString(1, dname);
				ps.setLong(3, did);
				ps.setLong(2, sid);
				
			}
		});
		if(res > 0)
		{
			return res;
		}
		else
		{
			return res;
		}
	}

	@Override
	public List<District> getDistrictByStateId(String stateid) {
		// TODO Auto-generated method stub
		
		List<District> dist = temp.query("select * from tbl_district join tbl_state ON tbl_state.state_id=tbl_district.state_id where tbl_district.state_id='"+stateid+"'", new RowMapper<District>() {

			@Override
			public District mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				District district = new District();
				
				district.setDist_id(rs.getLong(1));
				district.setDist_name(rs.getString(2));
				district.setState_id(rs.getLong(3));
				
				return district;
			}
		});
		
		return dist;
	}

}
