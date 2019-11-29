package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.repo.CustomerRepository;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	@Override
	public Customer findByName(String name) {
		Customer customer=repo.findByName(name);
		return customer;
	}

	@Override
	public Customer findByEmail(String email) {
		Customer customer=repo.findByEmail(email);
		return customer;
	}

	@Override
	public Account findByAccountAccountNumber(Long accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllcustomers() {
		List<Customer> customers=repo.findAll();
		return customers;
	}

	@Override
	public void deleteCustomerById(long id) {
		// TODO Auto-generated method stub
		repo.deleteAcustomerById(id);
	}

}
