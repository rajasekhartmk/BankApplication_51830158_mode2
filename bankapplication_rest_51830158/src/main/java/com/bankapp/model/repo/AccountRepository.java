package com.bankapp.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.entities.Account;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	public List<Account> findAll();
	public Account findByAccountNumber(Long accountNumber);
}
