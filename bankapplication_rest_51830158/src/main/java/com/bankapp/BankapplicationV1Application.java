package com.bankapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bankapp.model.entities.User;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.AccountTransactionRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.repo.UserRepository;
import com.bankapp.model.service.AccountService;

@EnableTransactionManagement
@SpringBootApplication
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
		
//		accountService.withdraw(1L, 500);
//		Account account=accountService.findByAccountNumber(1L);
//		System.out.println(account);
		
		
//		Customer customer1=new Customer("rstmk","rstmk@gmail.com", "9949989618", "Karnataka", "bangalore", "India");
//		Customer customer2=new Customer("link","link@gmail.com", "994", "Tamilnadu", "chennai", "India");
//		Customer customer3=new Customer("poll","poll@gmail.com", "994998", "Andhra", "gutur", "India");
//		
//		Account account1=new Account(50000.00, customer1, false);
//		Account account2=new Account(40000.00, customer2, false);
//		Account account3=new Account(60000.00, customer3, false);
//		
//		customer1.setAccount(account1);
//		customer2.setAccount(account2);
//		customer3.setAccount(account3);
//		
//		accountRepository.save(account1);
//		accountRepository.save(account2);
//		accountRepository.save(account3);
		
		
		
//		User user1=new User("raj", "raj100", "raj@gmail.com", "9949989618", "bangalore", 
//				new String[]{"ROLE_ADMIN"}, true);
//		
//		User user2=new User("king", "king100", "king@gmail.com", "99499896", "guntur", 
//				new String[]{"ROLE_MGR"}, true);
//		
//		User user3=new User("int", "int100", "int@gmail.com", "99499", "chennai", 
//				new String[]{"ROLE_CLERK"}, true);
//
//
//		userRepository.save(user1);
//		userRepository.save(user2);
//		userRepository.save(user3);
		
		
	}

}

