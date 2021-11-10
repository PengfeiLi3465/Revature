package com.revature.orderingsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.orderingsystem.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
