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

import com.revature.orderingsystem.model.Item;
import com.revature.orderingsystem.service.ItemService;

@RestController
//@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@GetMapping("/items")
	public List<Item> getItems(){
		return itemService.findAll();
	}
	
	@GetMapping("/items/{id}")
	public Item getItemById(@PathVariable int id) {
		return itemService.findById(id);
	}
	
	@PostMapping("/items")
	public void saveItem(@RequestBody Item item) {
		itemService.save(item);
	}
	
	@PutMapping("/items/{id}")
	public void editItem(@PathVariable int id, @RequestBody Item item) {
		itemService.save(item);
	}

	@DeleteMapping("/items/{id}")
	public void deleteItemById(@PathVariable int id) {
		itemService.delete(id);
	}
}