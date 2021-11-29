package com.revature.orderingsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.orderingsystem.model.Detail;

public interface DetailRepository extends JpaRepository<Detail, Integer> {

	List<Detail> findAllByorderId(int orderId);

}
