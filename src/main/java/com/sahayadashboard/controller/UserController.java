package com.sahayadashboard.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahayadashboard.model.User;
import com.sahayadashboard.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService uService;
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return uService.createUser(user) ;
	
	}
	
	@GetMapping("/{UUID}")
	public Optional<User> getUserByUuid(@PathVariable String uuid){
		return uService.getUserByUuid(UUID.fromString(uuid));
		
	}
	
	@GetMapping
	public List<User> getAllUser(){
		return uService.getAllUser();
		
	}
	
	
	
	

}
