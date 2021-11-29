package com.revature.orderingsystem.service;

import java.util.List;

import com.revature.orderingsystem.model.Detail;

public interface DetailService {
	List<Detail> findAll();

	Detail findById(int detailId);
	
	List<Detail> findByorderId(int orderId);//not implement yet
	
	void save(Detail detail);

	void update(int detailId, Detail detail);

	void delete(int detailId);

	
}
