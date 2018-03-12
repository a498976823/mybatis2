package com.orilore.model;

import java.beans.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import net.minidev.json.writer.BeansMapper.Bean;

public class DeptRowMapper implements RowMapper<Dept>{

	@Override
	public Dept mapRow(ResultSet rs, int arg1) throws SQLException {
		Dept bean =new Dept();
		bean.setId(rs.getInt("id"));
		bean.setName(rs.getString("name"));
		bean.setStatus(rs.getInt("status"));
		return bean;
	}



}
