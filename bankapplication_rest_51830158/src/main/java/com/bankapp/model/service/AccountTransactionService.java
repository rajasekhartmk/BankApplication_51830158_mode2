package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.AccountTransaction;

public interface AccountTransactionService {

	List<AccountTransaction> findAll();
    List<AccountTransaction> findByAccountAccountNumber(Long accountNumber);
}
