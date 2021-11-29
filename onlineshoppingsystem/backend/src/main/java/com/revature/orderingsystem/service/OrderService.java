package com.revature.orderingsystem.service;

import java.util.List;

import com.revature.orderingsystem.model.Order;

public interface OrderService {
	List<Order> findAll();

	Order findById(int orderId);

	List<Order> findByuserId(int userId);//not implement yet
	
	void save(Order order);

	void update(int orderId, Order order);

	void delete(int orderId);

	
}
