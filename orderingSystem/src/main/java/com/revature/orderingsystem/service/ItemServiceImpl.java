package com.revature.orderingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.orderingsystem.model.Item;
import com.revature.orderingsystem.repo.ItemRepository;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemRepository itemRepository;

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public Item findById(int id) {
		// TODO Auto-generated method stub
		return itemRepository.findById(id).get();
	}

	@Override
	public void save(Item item) {
		// TODO Auto-generated method stub
		itemRepository.save(item);
	}

	@Override
	public void update(int id, Item item) {
		// TODO Auto-generated method stub
		itemRepository.save(item);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(id);
	}

}
