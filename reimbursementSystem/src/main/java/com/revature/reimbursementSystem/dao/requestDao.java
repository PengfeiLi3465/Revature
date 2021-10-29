package com.revature.reimbursementSystem.dao;

import java.util.List;

import com.revature.reimbursementSystem.model.request;

public interface requestDao {

	request createRequest(request reimbursement);

	request getRequest(int request_id);

	List<request> getAllRequest();

	request updateRequest(request reimbursement);

	List<request> getRequestByAccountId(int account_id);

}
