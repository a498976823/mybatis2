package com.orilore.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class personRowMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int arg) throws SQLException {
			
		Person bean = new Person();
		bean.setName(rs.getString("name"));
		bean.setBrithday(rs.getString("brithday"));
		bean.setDeptid(rs.getInt("deptid"));
		bean.setPhone(rs.getString("phone"));
		bean.setStatus(rs.getInt("status"));
		return bean;
		
			
		
	}
		
}
