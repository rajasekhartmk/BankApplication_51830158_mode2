package com.custApp.model.service;

import java.util.List;

import com.custApp.model.persistance.Emp;

public interface EmpService {
	public Emp getEmp(String email , String password);
	public void addEmp(Emp emp);
	public List<Emp> getAllEmp();
}
