package com.orilore.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.orilore.model.Dept;
import com.orilore.model.Person;
import com.orilore.model.personRowMapper;
@Repository
public class PersonDAO implements IPersonDao {
	
	@Resource
	private JdbcTemplate template;

	public List<Person> selectAll(Person bean) {
		String sql = "select * from persons where status!=-1 ";
		String name=bean.getName();
		String phone = bean.getPhone();
		int  deptid = bean.getDeptid();
		if (name!=null && !"".equals(name)) {
			sql+=" and name like '%"+name+"' % ";	
			
		}
		if (phone!=null && !"".equals(phone)) {
			sql+=" and phone='"+phone+"' % ";	
			
		}
		if (deptid>0) {
			sql+=" and deptid="+deptid;	
			
		}
		return this.template.query(sql,new personRowMapper());
		
		
		
		
	}

	@Override
	public Person selectOne(Person bean) {
		
		return this.template.queryForObject("select * from persons where deptid=?",new Object[] {bean.getDeptid()}, new personRowMapper());
		
		
	}

	@Override
	public boolean remove(int id) {
		int n = this.template.update("update persons set status=-1 where id=?",id);
		if (n>0) {
			return true;
			
		}
		return false;
	}

	@Override
	public boolean insert(Person bean) {
		
		int n = this.template.update("insert into persons(name,brithday,phone,deptid,) values(?,?,?,?)",bean.getName(),bean.getBrithday(),bean.getPhone(),bean.getDeptid());
		if (n>0) {
			return true;
			
		}
		return false;
	}

	@Override
	public boolean update(Person bean) {
		Object[] ps = new Object[]{
				bean.getName(),			
				bean.getBrithday(),
				bean.getPhone(),
				bean.getDeptid(),
				bean.getId()
		};
		String sql = "update person set name=?,brithday=?,phone=?,deptid=? where id=?";
		if(this.template.update(sql,ps)>0){
			return true;
		}
		return false;
	}




}
