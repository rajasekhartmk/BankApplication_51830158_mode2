package com.custApp.model.persistance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class EmpDAOImpl implements EmpDAO{

	@Autowired
	private SessionFactory factory;

	public Session getSession() {
		return factory.getCurrentSession();
	}
	
	@Override
	public Emp getEmp(String email, String password) {
		@SuppressWarnings("unchecked")
		List<Emp> emp = getSession().createQuery("select e from Emp e where e.email=:email and e.password=:password")
				.setString("email", email).setString("password", password).list();
		if (emp.size() > 0)
			return emp.get(0);
		else
			throw new EmpNotFoundException("emp with this email" + " " + email + " is not there");
		
	
	}

	@Override
	public void addEmp(Emp emp) {
		getSession().save(emp);
	}

	@Override
	public List<Emp> getAllEmp() {
		return getSession().createQuery("from Emp").list();
	}

}
