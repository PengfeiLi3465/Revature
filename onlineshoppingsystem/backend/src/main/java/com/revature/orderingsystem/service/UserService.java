package com.revature.orderingsystem.service;

import java.util.List;

import com.revature.orderingsystem.model.User;

public interface UserService {
	List<User> findAll();

	User findById(int userId);

	User findByuserEmail(String userEmail);
	
	void save(User user);

	void update(int userId, User user);

	void delete(int userId);

	
}
