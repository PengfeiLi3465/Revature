package com.revature.orderingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.orderingsystem.model.User;
import com.revature.orderingsystem.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(int userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public User findByuserEmailanduserPassword(String userEmail,String userPassword) {
		return userRepository.findByUserEmailAndUserPassword(userEmail,userPassword).get();
	}
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void update(int userId, User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(int userId) {
		userRepository.deleteById(userId);
	}

}
