package com.custApp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.custApp.model.persistance.Emp;
import com.custApp.model.persistance.EmpDAO;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDAO empdao;
	
	@Override
	public Emp getEmp(String email, String password) {
		return empdao.getEmp(email, password);
	}

	@Override
	public void addEmp(Emp emp) {
		empdao.addEmp(emp);
	}

	@Override
	public List<Emp> getAllEmp() {
		return empdao.getAllEmp();
	}

}
