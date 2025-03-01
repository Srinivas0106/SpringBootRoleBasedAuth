package com.example.demo.controllers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService =userService;
	}
	
	@PostMapping("/user/login")
	public String login(@RequestBody Map<String,String> request) {
		
		String typeofuser = userService.authenticateUser(request.get("name"), request.get("password"));
		
		if(typeofuser.equalsIgnoreCase("customer")) {
			return "Welcome to customer Dashboard";
		} else if(typeofuser.equalsIgnoreCase("admin")) {
			return "Welcome to Admin DashBoard";
		} else {
			return"INVALID USERNAME OR PASSWORD";
		}
	}
		
	
}
