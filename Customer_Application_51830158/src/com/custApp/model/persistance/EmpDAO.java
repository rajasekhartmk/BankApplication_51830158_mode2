package com.custApp.model.persistance;

import java.util.List;

public interface EmpDAO {
	public Emp getEmp(String email , String password);
	public void addEmp(Emp emp);
	public List<Emp> getAllEmp();
}
