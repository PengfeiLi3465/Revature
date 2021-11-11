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

import com.revature.orderingsystem.model.Order;
import com.revature.orderingsystem.service.OrderService;

@RestController
//@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@GetMapping("/orders")
	public List<Order> getOrders(){
		return orderService.findAll();
	}
	
	@GetMapping("/orders/{orderId}")
	public Order getOrderById(@PathVariable int orderId) {
		return orderService.findById(orderId);
	}
	
	@GetMapping("/ordersbyuserid/{userId}")
	public List<Order> getOrdersByUserId(@PathVariable int userId){
		return orderService.findByuserId(userId);
	}
	
	@PostMapping("/orders")
	public void saveOrder(@RequestBody Order order) {
		orderService.save(order);
	}
	
	@PutMapping("/orders/{orderId}")
	public void editOrder(@PathVariable int orderId,@RequestBody Order order) {
		orderService.save(order);
	}
	@DeleteMapping("/orders/{orderId}")
	public void deleteOrderById(@PathVariable int orderId) {
		orderService.delete(orderId);
	}
	
}
