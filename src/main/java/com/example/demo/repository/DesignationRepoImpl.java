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

import com.example.demo.models.Designation;
import com.example.demo.models.Hospital;

@Repository("desigrepo")
public class DesignationRepoImpl implements DesignationRepo {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public int saveDesignation(Designation desig) {
		// TODO Auto-generated method stub
		return temp.update("INSERT INTO tbl_designation values('0',?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, desig.getDesig_name());
				ps.setLong(2, desig.getHosp_id());
			}
		});
	}

	@Override
	public List<Designation> getAllDesignations() {
		// TODO Auto-generated method stub
		return temp.query("SELECT * FROM tbl_designation JOIN tbl_hospital ON tbl_hospital.hosp_id=tbl_designation.hosp_id", new RowMapper<Designation>() {

			@Override
			public Designation mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Designation desig = new Designation();
				
				desig.setDesig_id(rs.getLong(1));
				desig.setDesig_name(rs.getString(2));
				desig.setHosp_id(rs.getLong(3));
				
				Hospital hosp = new Hospital();
				
				hosp.setHosp_id(rs.getLong(4));
				hosp.setHosp_name(rs.getString(5));
				hosp.setHosp_email(rs.getString(6));
				hosp.setHosp_contact(rs.getString(7));
				hosp.setHosp_address(rs.getString(8));
				hosp.setHosp_reg_num(rs.getString(9));
				hosp.setZip_id(rs.getLong(10));
				
				desig.setHospital(hosp);
				return desig;
			}
		});
	}

	@Override
	public Designation getDesignationById(String id) {
		// TODO Auto-generated method stub
		return temp.queryForObject("SELECT * FROM tbl_designation WHERE desig_id='"+id+"'", new BeanPropertyRowMapper<Designation>(Designation.class));
	}

	@Override
	public int updateDesignation(Designation desig) {
		// TODO Auto-generated method stub
		
		return temp.update("UPDATE tbl_designation SET desig_name=?,hosp_id=? WHERE desig_id=?", new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					
					ps.setString(1, desig.getDesig_name());
					ps.setLong(2, desig.getHosp_id());
					ps.setLong(3, desig.getDesig_id());
				}
			});
	}

}
