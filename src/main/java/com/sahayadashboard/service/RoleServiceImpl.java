package com.sahayadashboard.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahayadashboard.model.Role;
import com.sahayadashboard.repository.RoleRepository;

@Service

public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository rRepository;

	@Override
	public Role createRole(Role role) {
		return rRepository.save(role);
		
	}

	@Override
	public Optional<Role> getRoleByUuid(UUID uuid) {
		 return rRepository.findById(uuid);
	}
	
	@Override
	public List<Role>getAllRole(){
		return rRepository.findAll();
	}
	
	
	@Override
	public String deleteByUuid(UUID uuid) {
		rRepository.deleteById(uuid);
		return "deleted successfully";
		
	}
	
	@Override
	public Role updateByUuid(UUID uuid, Role role) {
		Optional<Role>rl=rRepository.findById(uuid);
		Role r=rl.get();
		r.setName(role.getName());
		r.setUpdatedAt(role.getUpdatedAt());
		return rRepository.save(r);
		
		
		
	}
	
	


}
