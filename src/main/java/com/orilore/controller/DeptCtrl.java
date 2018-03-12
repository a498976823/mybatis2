package com.orilore.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orilore.dao.IDeptDao;
import com.orilore.model.Dept;

@RestController
public class DeptCtrl {
			@Resource
			private IDeptDao dao;
			@RequestMapping("/dept/query")
			public List<Dept> query(){
				
				return this.dao.selectAll();
				
				
			}
			@RequestMapping("/dept/remove")
			public boolean remove(int id) {
				
				return this.dao.remove(id);
				
				
			}
			@RequestMapping("/dept/update")
			public boolean update(Dept bean) {
				
				return this.dao.update(bean);
				
			}
			@RequestMapping("/dept/insert")
			public boolean insert(Dept bean) {
				
				return this.dao.insert(bean);
				
			}
	

}
