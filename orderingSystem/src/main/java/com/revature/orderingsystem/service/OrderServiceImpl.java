package com.revature.orderingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.orderingsystem.model.Order;
import com.revature.orderingsystem.repo.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findById(int orderId) {
		return orderRepository.findById(orderId).get();
	}
	@Override
	public List<Order> findByuserId(int userId){
		return orderRepository.findAllByuserId(userId);
	}

	@Override
	public void save(Order order) {
		orderRepository.save(order);
	}

	@Override
	public void update(int orderId, Order order) {
		orderRepository.save(order);
	}

	@Override
	public void delete(int orderId) {
		orderRepository.deleteById(orderId);
	}

}
