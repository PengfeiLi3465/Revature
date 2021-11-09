package com.revature.orderingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.orderingsystem.model.Detail;
import com.revature.orderingsystem.repo.DetailRepository;

@Service
public class DetailServiceImpl implements DetailService {

	@Autowired
	DetailRepository detailRepository;

	@Override
	public List<Detail> findAll() {
		return detailRepository.findAll();
	}

	@Override
	public Detail findById(int detailId) {
		return detailRepository.findById(detailId).get();
	}
	
	@Override
	public List<Detail> findByorderId(int orderId){
		return detailRepository.findAllByorderId(orderId);
	}
	
	@Override
	public void save(Detail detail) {
		detailRepository.save(detail);
	}

	@Override
	public void update(int detailId, Detail detail) {
		detailRepository.save(detail);
	}

	@Override
	public void delete(int detailId) {
		detailRepository.deleteById(detailId);
	}

}
