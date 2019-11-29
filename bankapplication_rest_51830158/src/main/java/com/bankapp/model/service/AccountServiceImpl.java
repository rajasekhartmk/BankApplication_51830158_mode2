package com.bankapp.model.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
import com.bankapp.model.service.exceptions.NotSufficientFundException;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountTransactionRepository accountTransactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TransactionLogRepository transactionLogRepository;

	@Override
	public void blockAccount(Long accountNumber) {

	}

	@Override
	public void createAccount(Account account) {
		accountRepository.save(account);
		customerRepository.save(account.getCustomer());
	}

	@Override
	public void deposit(Long accountNumber, double amount,String authority) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotFoundException::new);
		account.setBalance(account.getBalance() + amount);
		
		AccountTransaction accountTransaction=new AccountTransaction("deposit", amount);
		account.addAccountTransaction(accountTransaction);
		accountRepository.save(account);
		
		TransactionLog log=new TransactionLog
				(null, accountNumber, "deposit", amount, authority, "done");
		transactionLogRepository.save(log);
		//accountTransactionRepository.save(accountTransaction);
	}

	@Override
	public void withdraw(Long accountNumber, double amount,String authority) {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(AccountNotFoundException::new);
		// min bal should be 1000 in any case
		if (account.getBalance() - amount < 1000)
			throw new NotSufficientFundException();
		account.setBalance(account.getBalance() - amount);
		
		AccountTransaction accountTransaction=new AccountTransaction("withdrawl", amount);
		account.addAccountTransaction(accountTransaction);
		accountRepository.save(account);
		
		TransactionLog log=new TransactionLog(accountNumber, null, "withdrawl", amount, authority, "done");
		transactionLogRepository.save(log);
	}
	
	@Override
	public void transfer(Long fromAccNumber, Long toAccNumber, double amount,String authority) {
		Account account1=accountRepository.findByAccountNumber(fromAccNumber);
		account1.setBalance(account1.getBalance()-amount);
		Account account2=accountRepository.findByAccountNumber(toAccNumber);
		account2.setBalance(account1.getBalance()+amount);
		accountRepository.save(account1);
		accountRepository.save(account2);
		
		AccountTransaction accountTransaction=new AccountTransaction("transaction",amount);
		account1.addAccountTransaction(accountTransaction);
		account2.addAccountTransaction(accountTransaction);
		
		TransactionLog log=new TransactionLog(fromAccNumber, toAccNumber, "transfer", amount, authority, "done");
		transactionLogRepository.save(log);
		
	}

//	@Override
//	public List<Account> findAll() {
//		List<Account> accounts=accountRepository.findAll();
//		return accounts;
//	}

	@Override
	public Account findByAccountNumber(Long accountNumber) {
		Account account=accountRepository.findByAccountNumber(accountNumber);
		return account;
	}

	@Override
	public void deleteAccountById(long id) {
		accountRepository.deleteById(id);
	}


	@Override
	public Account updateAccount(Account account, Long accountNumber) {
		Account updateAccount=accountRepository.findByAccountNumber(accountNumber);
//		updateAccount.getCustomer().setEmail(account.getCustomer().getEmail());
//		updateAccount.getCustomer().setPhone(account.getCustomer().getPhone());
//		updateAccount.getCustomer().setAddress(account.getCustomer().getAddress());
//		updateAccount.getCustomer().setCity(account.getCustomer().getCity());
		accountRepository.save(updateAccount);
		return updateAccount;
	}


}




