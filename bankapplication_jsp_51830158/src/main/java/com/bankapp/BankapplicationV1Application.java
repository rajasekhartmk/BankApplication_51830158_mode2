package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.repo.UserRepository;
import com.bankapp.model.service.AccountService;

@SpringBootApplication
@EnableTransactionManagement
public class BankapplicationV1Application implements CommandLineRunner {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountTransactionRepository accountTransactionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TransactionLogRepository transactionLogRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankapplicationV1Application.class, args);
	}

	@Autowired
	private AccountService accountService;

	@Override
	public void run(String... args) throws Exception {

		// accountService.deposit(2L, 100);

		/*
		 * Account
		 * account=accountRepository.findById(1L).orElseThrow(RuntimeException
		 * ::new); accountRepository.delete(account);
		 */

		
//		  Customer customer=new Customer("rstmk", "rstmk@gmail.com", "9949989618","bangalore", "bangalore", "India"); 
//		  Customer customer2=new Customer("link","link@gmail.com", "99499", "chennai", "TamilNadu", "India"); 
//		  Customer customer3=new Customer("poll", "poll@gmail.com", "99499896","banglore", "bangalore", "India");
//		  
//		  Account account=new Account(50000.0, customer, false); 
//		  Account account2=new Account(60000.0, customer2, false); 
//		  Account account3=new Account(40000.0, customer3, false);
//		  
//		  customer.setAccount(account); 
//		  customer2.setAccount(account2);
//		  customer3.setAccount(account3);
//		  
//		  accountRepository.save(account); 
//		  accountRepository.save(account2);
//		  accountRepository.save(account3);
		 

//		User user1 = new User("raj", "raj100", "raj@gmail.com", "9949989618",
//				"bangalore", new String[] { "ROLE_ADMIN" }, true);
//
//		User user2 = new User("king", "king100", "king@gmail.com", "99499896",
//				"guntur", new String[] { "ROLE_MGR" }, true);
//
//		User user3 = new User("int", "int100", "int@gmail.com", "99499",
//				"chennai", new String[] { "ROLE_CLERK" }, true);
//
//		userRepository.save(user1);
//		userRepository.save(user2);
//		userRepository.save(user3);

	}

}
