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
		User user=repo.findByEmail(email);
		return user;
	}

	@Override
	public User addUser(User user) {
		User addUser=user;
		repo.save(user);
		return addUser;
	}
	
	@Override
	public List<User> findAll() {
		List<User> users=repo.findAll();
		return users;
	}

	@Override
	public void blockUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Long userId) {
		repo.deleteById(userId);
	}

	@Override
	public User findById(Long id) {
		User user=repo.findById(id).orElseThrow(UserNotFoundException::new);
		return user;
	}
	
	@Override
	public User update(long id,User user) {
		User updateUser=repo.findById(id).orElseThrow(UserNotFoundException::new);
		updateUser.setPhone(user.getPhone());
		repo.save(updateUser);
		return updateUser;
	}

}
