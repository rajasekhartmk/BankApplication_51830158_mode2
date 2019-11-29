package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.User;
import com.bankapp.model.repo.UserRepository;
import com.bankapp.model.service.exceptions.UserNotFoundException;
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void addUser(User user) {
		repo.save(user);
	}

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public void blockUser(Long userId) {
		
	}

	@Override
	public void deleteUserById(long id) {
		repo.deleteById(id);
	}

	@Override
	public User findById(long id) {
		return repo.findById(id).orElseThrow(UserNotFoundException::new);
	}

	@Override
	public User update(long id,User user) {
		User updateUser=repo.findById(id).orElseThrow(UserNotFoundException::new);
		repo.save(updateUser);
		return updateUser;
	}


}
