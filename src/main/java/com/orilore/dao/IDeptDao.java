package com.orilore.dao;

import java.util.List;

import com.orilore.model.Dept;

public interface IDeptDao {
	 public List<Dept> selectAll();
	 
	 public boolean remove(int id);
	 
	 public boolean insert(Dept bean);
	 
	 public boolean update(Dept bean);
	 
	 public Dept selectOne(int id);

}
