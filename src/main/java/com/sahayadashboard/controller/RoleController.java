package com.sahayadashboard.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahayadashboard.model.Role;
import com.sahayadashboard.service.RoleService;

@RestController
@RequestMapping("/role")

public class RoleController {
	@Autowired
	private RoleService rService;
	
	@PostMapping
	public Role createRole(@RequestBody Role role) {
		 rService.createRole(role);
		 return role;
	}
	
	@GetMapping("/{uuid}")
	 public Optional<Role> getRoleByUuid(@PathVariable String uuid){
		return rService.getRoleByUuid(UUID.fromString(uuid));
	}
	
	@GetMapping
	public  List<Role>getAllRole(){
		return rService.getAllRole();
		
	}
	
	@DeleteMapping("/{uuid}")
	public String deleteByUuid(@PathVariable String uuid) {
		return rService.deleteByUuid(UUID.fromString(uuid));
		
	}
	
	@PutMapping("/{uuid}")
	public Role updateByUuid(@PathVariable String uuid,@RequestBody Role role) {
		 return rService.updateByUuid(UUID.fromString(uuid), role);
		 
	}
	

}
