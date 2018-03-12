package com.orilore.dao;

import java.util.List;
import org.assertj.core.data.Percentage;

import com.orilore.model.Dept;
import com.orilore.model.Person;
import com.orilore.model.personRowMapper;

public interface IPersonDao {

	public List<Person> selectAll(Person bean);
	 
	 public Person selectOne(Person bean);
	 
	 public boolean remove(int id);
	 
	 public boolean insert(Person bean);
	 
	 public boolean update(Person bean);

	
	 

}
