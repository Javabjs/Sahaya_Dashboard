package com.sahayadashboard.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahayadashboard.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

	Optional<Role> findById(UUID uuid);

}
