package com.revature.reimbursementSystem.daotest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.revature.reimbursementSystem.dao.requestDao;
import com.revature.reimbursementSystem.dao.requestDaoImp;
import com.revature.reimbursementSystem.model.request;

public class requestDaoTest {
	private static requestDao rdao = new requestDaoImp();

	@Test
	public void testcreateRequest() {
		request testRequest = new request();
		testRequest.setAccount_id(2);
		testRequest.setConditiontype_id(1);
		testRequest.setDescription("for unit test");
		testRequest.setAmount(10f);
		rdao.createRequest(testRequest);

		List<request> requests = new ArrayList<request>();
		requests = rdao.getAllRequest();
		request result = requests.get(requests.size() - 1);

		assertEquals(testRequest.getDescription(), result.getDescription());

	}

	@Test
	public void testgetRequest() {
		request testRequest = new request(1, 2, 3, "first description", "first note", 66.66f);
		request result = rdao.getRequest(1);

		assertEquals(testRequest.getAccount_id(), result.getAccount_id());
		assertEquals(testRequest.getDescription(), result.getDescription());
		assertEquals(testRequest.getNote(), result.getNote());
		assertEquals(testRequest.getRequest_id(), result.getRequest_id());

	}

	@Test
	public void testupdateRequest() {
		request testRequest = new request();
		testRequest.setRequest_id(4);
		testRequest.setAccount_id(2);
		testRequest.setConditiontype_id(2);
		testRequest.setDescription("test3");
		testRequest.setNote("junit test update");// modify to test
		testRequest.setAmount(13.54f);
		rdao.updateRequest(testRequest);

		request result = rdao.getRequest(2);
		assertEquals(testRequest.getNote(), result.getNote());

	}

	@Test
	public void testgetAllRequest() {
		List<request> result = rdao.getAllRequest();
		assertNotEquals(0, result.size());
	}

	@Test
	public void testgetRequestByAccountId() {
		List<request> result = rdao.getRequestByAccountId(2);
		assertNotEquals(0, result.size());
	}

}
