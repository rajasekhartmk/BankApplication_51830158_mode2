package com.bankapp.model.service;
import java.util.*;
import com.bankapp.model.entities.User;

public interface UserService {
	public User findByEmail(String email);
	public User findById(Long id);
	public User addUser(User user);
	public List<User> findAll();
	public void blockUser(Long userId);
	public void deleteUser(Long userId);
	
	public User update(long id,User user);
}
