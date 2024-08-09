package com.sahayadashboard.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahayadashboard.security.jwtUtils.JwtHelper;

@RestController
@RequestMapping("/roledemo")
public class RoleDemoController {
	
	@GetMapping("/roles")
    public List<String> getRoles(@RequestHeader String authHeader) {
		String token = authHeader.substring(7);
		return JwtHelper.getRolesFromToken(token);
       
	
	
	}
}
