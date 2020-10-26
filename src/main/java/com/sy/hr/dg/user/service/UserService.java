package com.sy.hr.dg.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sy.hr.dg.user.repository.UserRepository;
import com.sy.hr.dg.user.vo.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Optional<User> findByEmail(String email)  {
		return userRepository.findByEmail( email );
	}

	public User save(User user) {
		return userRepository.save( user );
	}
	
}
