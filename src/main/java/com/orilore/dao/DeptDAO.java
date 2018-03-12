package com.orilore.dao;

import java.util.List;

import javax.annotation.Resource;

import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.orilore.model.Dept;
import com.orilore.model.DeptRowMapper;
@Repository
public class DeptDAO implements IDeptDao {
	@Resource
	private JdbcTemplate template;
	
	@Override
	public List<Dept> selectAll() {
		return this.template.query("select * from depts where status!=-1", new DeptRowMapper());
		
	}

	@Override
	public boolean remove(int id) {
		int n= this.template.update("update depts set status=-1 where id=?",id);
		if(n>0) {
			return true;
		}
			return false;
	}

	@Override
	public boolean insert(Dept bean) {
		int n= this.template.update("insert into depts(name) values(?)",bean.getName());
		if(n>0) {
			return true;
		}
			return false;
	}

	@Override
	public boolean update(Dept bean) {
		int n= this.template.update("update depts set name=? where id=?",bean.getName(),bean.getId());
		if(n>0) {
			return true;
		}
			return false;
	}

	@Override
	public Dept selectOne(int id) {
			
		return  this.template.queryForObject("select * from depts where id=?",new Object[] {id},new DeptRowMapper() );
	}

}
