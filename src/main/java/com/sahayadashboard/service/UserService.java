package com.sahayadashboard.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sahayadashboard.model.User;

public interface UserService {
	User createUser(User user);
	Optional<User> getUserByUuid(UUID uuid );
	List<User> getAllUser();
	String deleteByUuid(UUID uuid);
	User updateByUuid(UUID uuid, User user);

}
