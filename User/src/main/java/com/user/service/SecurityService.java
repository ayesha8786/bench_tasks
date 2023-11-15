package com.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.entity.Users;
import com.user.repository.UserRepository;

@Service
public class SecurityService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users foundedUser = userRepository.findByUsername(username);
		if (foundedUser == null)
			return null;

		String name = foundedUser.getUsername();
		String pwd = foundedUser.getPassword();
		String email = foundedUser.getEmail();
		return new User(name, pwd, new ArrayList<>());

	}

}
