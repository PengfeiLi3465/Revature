package com.revature.orderingsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.orderingsystem.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findAllByuserId(int userId);

}
