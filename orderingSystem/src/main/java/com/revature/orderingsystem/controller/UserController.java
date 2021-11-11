package com.revature.orderingsystem.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.orderingsystem.model.User;
import com.revature.orderingsystem.service.UserService;

@RestController
//@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public User getUserById(@PathVariable int userId) {
		return userService.findById(userId);
	}
	
	@GetMapping("/userbyemail/{userEmail}")
	public User getUserByUserEmail(@PathVariable String userEmail) {
		return userService.findByuserEmail(userEmail);
	}
	
	@PostMapping("/users")
	public void saveUser(@RequestBody User user) {
		userService.save(user);
	}
	
	@PutMapping("/users/{userId}")
	public void editUser(@PathVariable int userId,@RequestBody User user) {
		userService.save(user);
	}
	@DeleteMapping("/users/{userId}")
	public void deleteUserById(@PathVariable int userId) {
		userService.delete(userId);
	}
	
}
