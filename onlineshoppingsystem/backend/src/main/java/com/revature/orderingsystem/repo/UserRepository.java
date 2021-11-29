package com.revature.orderingsystem.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.orderingsystem.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserEmail(String userEmail);

}
