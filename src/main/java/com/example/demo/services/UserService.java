package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	
	UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public String authenticateUser(String name, String password) {
		User user =userRepository.findByName(name); // Specialized method from userReposity user defined 
		
		if(user == null) {
			return "Invalid User";
		} else {
			if(password.equals(user.getPassword())) {
				return user.getRole();
			} else {
				return "Invalid User";
			}
		}
	}
}
