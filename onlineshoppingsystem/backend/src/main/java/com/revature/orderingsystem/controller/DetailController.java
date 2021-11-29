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

import com.revature.orderingsystem.model.Detail;
import com.revature.orderingsystem.service.DetailService;

@RestController
//@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class DetailController {

	@Autowired
	DetailService detailService;
	
	@GetMapping("/details")
	public List<Detail> getDetails(){
		return detailService.findAll();
	}
	
	@GetMapping("/details/{detailId}")
	public Detail getDetailById(@PathVariable int detailId) {
		return detailService.findById(detailId);
	}
	
	@GetMapping("/detailsbyorderid/{orderId}")
	public List<Detail> getDetailsByOrderId(@PathVariable int orderId) {
		return detailService.findByorderId(orderId);
	}
	
	@PostMapping("/details")
	public void saveDetail(@RequestBody Detail detail) {
		detailService.save(detail);
	}
	
	@PutMapping("/details/{detailId}")
	public void editDetail(@PathVariable int detailId, @RequestBody Detail detail) {
		detailService.save(detail);
	}

	@DeleteMapping("/details/{detailId}")
	public void deleteDetailById(@PathVariable int detailId) {
		detailService.delete(detailId);
	}
}
