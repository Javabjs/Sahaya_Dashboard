package com.sahayadashboard.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahayadashboard.model.User;
import com.sahayadashboard.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/User")

public class UserController {
	
	@Autowired
	private UserService uService;
	
	@PostMapping("/{UUID}")
	public User createUser(@RequestBody User user) {
		return uService.createUser(user) ;
	
	}
	
	

}
