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

import com.example.demo.models.City;

@Repository("cityrepo")
public class CityRepoImpl implements CityRepository {

	@Autowired
	JdbcTemplate temp;
	
	
	@Override
	public boolean isSaveCity(City city) {
		// TODO Auto-generated method stub
		
		int res = temp.update("INSERT INTO tbl_city values('0',?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
			
				Long did 	= city.getDist_id();
				String cname= city.getCity_name();
				
				ps.setString(1, cname);
				ps.setLong(2, did);
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
	public City getCityById(String id) {
		// TODO Auto-generated method stub
		
		City city = temp.queryForObject("select * from tbl_city JOIN tbl_district on tbl_district.dist_id=tbl_city.dist_id JOIN tbl_state ON tbl_state.state_id=tbl_district.dist_id WHERE tbl_city.city_id='"+id+"'", new BeanPropertyRowMapper<City>(City.class));
		
		return city;
	}

	@Override
	public List<City> getAllCities() {
		// TODO Auto-generated method stub
		
		List<City>  clist = temp.query("select * from tbl_city JOIN tbl_district on tbl_district.dist_id=tbl_city.dist_id JOIN tbl_state ON tbl_state.state_id=tbl_district.state_id ", new RowMapper<City>() {

			@Override
			public City mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				City city = new City();
				
				city.setCity_id(rs.getLong(1));
				city.setCity_name(rs.getString(2));
				city.setDist_id(rs.getLong(3));
				city.setDist_name(rs.getString(5));
				city.setState_id(rs.getLong(6));
				city.setState_name(rs.getString(8));
				
				return city;
			}
		});
		return clist;
	}

	@Override
	public int updateCity(City city) {
		// TODO Auto-generated method stub
		
		int res = temp.update("update tbl_city set city_name=?,dist_id=? where city_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				String cname = city.getCity_name();
				Long cid = city.getCity_id();
				Long did  = city.getDist_id();
				
				ps.setString(1, cname);
				ps.setLong(2, did);
				ps.setLong(3, cid);
				
			}
		});
		if(res > 0) {
			return res;
		}	
		else {
			return res;
		}
	}

	@Override
	public List<City> getcitybydistid(String did) {
		// TODO Auto-generated method stub
		
		List<City> clist = temp.query("SELECT * FROM tbl_city JOIN tbl_district ON tbl_district.dist_id=tbl_city.dist_id JOIN tbl_state ON tbl_state.state_id=tbl_district.state_id WHERE tbl_city.dist_id='"+did+"'", new RowMapper<City>() {

			@Override
			public City mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				City city = new City();
				
				city.setCity_id(rs.getLong(1));
				city.setCity_name(rs.getString(2));
				city.setDist_id(rs.getLong(3));
				city.setDist_name(rs.getString(5));
				
				city.setState_id(rs.getLong(6));
				city.setState_name(rs.getString(8));
				
				return city;
			}
		});
 		
		return clist;
	}

}
