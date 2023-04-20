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

import com.example.demo.models.Zip;

@Repository("ziprepo")
public class ZipRepoImpl implements ZipRepo {

	@Autowired
	JdbcTemplate temp;
	
	@Override
	public boolean saveZipCode(Zip zip) {
		// TODO Auto-generated method stub
		
		int res = temp.update("insert into tbl_zip values('0',?,?)", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
			
				String zcode = zip.getZipcode();
				Long cid = zip.getCity_id();
				
				ps.setString(1, zcode);
				ps.setLong(2, cid);
			}
		});
		
		if(res>0){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public Zip getZipByZipId(String zid) {
		// TODO Auto-generated method stub
		
		Zip zip = temp.queryForObject("select * from tbl_zip JOIN tbl_city ON tbl_city.city_id=tbl_zip.city_id JOIN tbl_district ON tbl_district.dist_id=tbl_city.dist_id JOIN tbl_state ON tbl_state.state_id=tbl_district.state_id where tbl_zip.zip_id='"+zid+"'",new BeanPropertyRowMapper<Zip>(Zip.class));
		
		return zip;
	}

	@Override
	public List<Zip> getAllZips() {
		// TODO Auto-generated method stub
		List<Zip> zlist = temp.query("select * from tbl_zip JOIN tbl_city ON tbl_city.city_id=tbl_zip.city_id JOIN tbl_district ON tbl_district.dist_id=tbl_city.dist_id JOIN tbl_state ON tbl_state.state_id=tbl_district.state_id", new RowMapper<Zip>() {

			@Override
			public Zip mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Zip zip = new Zip();
				
				zip.setZip_id(rs.getLong(1));
				zip.setZipcode(rs.getString(2));
				zip.setCity_id(rs.getLong(3));
				zip.setCity_name(rs.getString(5));
				zip.setDist_id(rs.getLong(7));
				zip.setDist_name(rs.getString(8));
				zip.setState_id(rs.getLong(10));
				zip.setState_name(rs.getString(11));
				
				
				return zip;
			}
		});
		
		return zlist;
	}

	@Override
	public List<Zip> getZipByCityId(String cid) {
		// TODO Auto-generated method stub
		
		List<Zip> zlist = temp.query("select * from tbl_zip JOIN tbl_city ON tbl_city.city_id=tbl_zip.city_id JOIN tbl_district ON tbl_district.dist_id=tbl_city.dist_id JOIN tbl_state ON tbl_state.state_id=tbl_district.state_id where tbl_zip.city_id='"+cid+"'", new RowMapper<Zip>() {

			@Override
			public Zip mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Zip zip = new Zip();
				
				zip.setZip_id(rs.getLong(1));
				zip.setZipcode(rs.getString(2));
				zip.setCity_id(rs.getLong(3));
				zip.setCity_name(rs.getString(5));
				zip.setDist_id(rs.getLong(7));
				zip.setDist_name(rs.getString(8));
				zip.setState_id(rs.getLong(10));
				zip.setState_name(rs.getString(11));
				
				return zip;
			}
		});
		
		return zlist;
		
	}

	@Override
	public int updateZipCode(Zip zip) {
		// TODO Auto-generated method stub
		
		int res = temp.update("update tbl_zip set zipcode=?,city_id=? where zip_id=?", new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				String zcode = zip.getZipcode();
				Long   cid   = zip.getCity_id();
				Long   zid   = zip.getZip_id();
				
				ps.setString(1, zcode);
				ps.setLong(2, cid);
				ps.setLong(3, zid);
				
			}
		});
		
		return res;
	}

}
