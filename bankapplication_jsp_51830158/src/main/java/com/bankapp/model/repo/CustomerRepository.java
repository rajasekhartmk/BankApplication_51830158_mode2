package com.bankapp.model.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Customer findByName(String name);
    Customer findByEmail(String email);
    Account findByAccountAccountNumber(Long accountNumber);
    public List<Customer> findAll();
    public Optional<Customer> findById(Long id);
}

