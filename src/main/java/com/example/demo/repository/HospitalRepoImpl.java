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
import com.example.demo.models.District;
import com.example.demo.models.Hospital;
import com.example.demo.models.State;
import com.example.demo.models.Zip;

@Repository
public class HospitalRepoImpl implements HospitalRepository {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public boolean isSaveHospital(Hospital hosp) {
		// TODO Auto-generated method stub
		
		int res = temp.update("insert into tbl_hospital values('0',?,?,?,?,?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
			
//				String hname  = hosp.getHosp_name();
//				String hemail = hosp.getHosp_email();
//				String hcont  = hosp.getHosp_contact();
//				String haddr  = hosp.getHosp_address();
//				String hregnum= hosp.getHosp_reg_num();
//				Long   zid	  = hosp.getZip_id();
				
				
				ps.setString(1, hosp.getHosp_name());
				ps.setString(2, hosp.getHosp_email());
				ps.setString(3, hosp.getHosp_contact());
				ps.setString(4, hosp.getHosp_address());
				ps.setString(5, hosp.getHosp_reg_num());
				ps.setLong(6, hosp.getZip_id());
				
			}
		});
		
		if(res >0){
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public List<Hospital> getAllHospitals() {
		// TODO Auto-generated method stub
		
		List<Hospital>  hlist =temp.query("select * from tbl_hospital JOIN tbl_zip on tbl_zip.zip_id=tbl_hospital.zip_id JOIN tbl_city ON tbl_city.city_id=tbl_zip.city_id JOIN tbl_district ON tbl_district.dist_id=tbl_city.dist_id JOIN tbl_state ON tbl_state.state_id=tbl_district.state_id", new RowMapper<Hospital>() {

			@Override
			public Hospital mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
			
				Hospital hosp = new Hospital();
			
				hosp.setHosp_id(rs.getLong(1));
				hosp.setHosp_name(rs.getString(2));
				hosp.setHosp_email(rs.getString(3));
				hosp.setHosp_contact(rs.getString(4));
				
				hosp.setHosp_address(rs.getString(5));
				
				hosp.setHosp_reg_num(rs.getString(6));
				hosp.setZip_id(rs.getLong(7));
				
				hosp.setZipcode(rs.getString(9));
				
				hosp.setCity_id(rs.getLong(10));
				hosp.setCity_name(rs.getString(12));
				hosp.setDist_id(rs.getLong(13));
				hosp.setDist_name(rs.getString(15));
				
				hosp.setState_id(rs.getLong(16));
				hosp.setState_name(rs.getString(18));
//				Zip zip = new Zip();
//				
//				zip.setZipcode(rs.getString(9));
//				
//				City city = new City();
//				city.setCity_id(rs.getLong(10));
//				city.setCity_name(rs.getString(12));
//				
//				District dist = new District();
//				
//				dist.setDist_id(rs.getLong(13));
//				dist.setDist_name(rs.getString(15));
//				
//				State state = new State();
//				
//				state.setState_id(rs.getLong(16));
//				state.setState_name(rs.getString(18));
				
				
				return hosp;
			}
		});
		
		return hlist;
	}

	@Override
	public Hospital getHospitalByHospId(String hospid) {
		// TODO Auto-generated method stub
		
		Hospital hosp = temp.queryForObject("select * from tbl_hospital JOIN tbl_zip on tbl_zip.zip_id=tbl_hospital.zip_id JOIN tbl_city ON tbl_city.city_id=tbl_zip.city_id JOIN tbl_district ON tbl_district.dist_id=tbl_city.dist_id JOIN tbl_state ON tbl_state.state_id=tbl_district.state_id where tbl_hospital.hosp_id='"+hospid+"'", new BeanPropertyRowMapper<Hospital>(Hospital.class));
		
		return hosp;
	}

	@Override
	public int updateHospital(Hospital hosp) {
		// TODO Auto-generated method stub
		int res =  temp.update("update tbl_hospital set hosp_name=?,hosp_email=?,hosp_contact=?,hosp_address=?,hosp_reg_num=?,zip_id=? where hosp_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				String hname  = hosp.getHosp_name();
				String hemail = hosp.getHosp_email();
				String hcont  = hosp.getHosp_contact();
				String haddr  = hosp.getHosp_address();
				String hregnum= hosp.getHosp_reg_num();
				Long   zid	  = hosp.getZip_id();
				Long hid	  = hosp.getHosp_id();
				
				ps.setString(1, hname);
				ps.setString(2, hemail);
				ps.setString(3, hcont);
				ps.setString(4, haddr);
				ps.setString(5, hregnum);
				ps.setLong(6, zid);
				ps.setLong(7, hid);
				
			}
		});
		
		return res;
	}

}
