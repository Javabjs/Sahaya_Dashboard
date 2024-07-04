package com.sahayadashboard.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sahayadashboard.model.Role;

public interface RoleService {
	Role createRole(Role role);
	Optional<Role> getRoleByUuid(UUID uuid );
	List<Role> getAllRole();
	String deleteByUuid(UUID uuid);
	Role updateByUuid(UUID uuid, Role role);
	

}
