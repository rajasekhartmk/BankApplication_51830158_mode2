package com.bankapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.User;
import com.bankapp.model.repo.UserRepository;
@Service
@Transactional
public class SpringUserDetailsService implements UserDetailsService {

	private UserService service;

	@Autowired
	public SpringUserDetailsService(UserService service) {
		this.service = service;
	}

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		User user = service.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("the user with email " + email
					+ " is not there check");
		}
		org.springframework.security.core.userdetails.User springUser = new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getRoles()));
		return springUser;
	}

}
