package com.revature.orderingsystem.service;

import java.util.List;

import com.revature.orderingsystem.model.Item;

public interface ItemService {
	List<Item> findAll();

	Item findById(int id);

	void save(Item item);

	void update(int id, Item item);

	void delete(int id);
}
