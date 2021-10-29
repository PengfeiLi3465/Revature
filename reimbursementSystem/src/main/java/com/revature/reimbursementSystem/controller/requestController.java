package com.revature.reimbursementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.revature.reimbursementSystem.dao.requestDao;
import com.revature.reimbursementSystem.dao.requestDaoImp;
import com.revature.reimbursementSystem.model.request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.javalin.http.Handler;

public class requestController {
	private static requestDao rdao = requestDaoImp.getDao();
	private static Gson gson = new Gson();
	private static Logger log = LoggerFactory.getLogger(requestController.class);
	public static Handler createRequest = (ctx) -> {
		String body = ctx.body();

		try {
			request reimbursement = gson.fromJson(body, request.class);
			if (reimbursement != null) {
				request returned = rdao.createRequest(reimbursement);
				ctx.result(gson.toJson(returned));
				ctx.status(200);
				log.info("new request inserted");
			} else
				ctx.status(404);
		} catch (Exception e) {
			ctx.status(404);
			e.printStackTrace();
		}
	};
	
	public static Handler updateRequest = (ctx) -> {
		String body = ctx.body();
		request rqst = gson.fromJson(body, request.class);
		request result = rdao.updateRequest(rqst);

		ctx.result(gson.toJson(result));
		ctx.status(202);
		log.info("request updated");
	};
	
	public static Handler getRequestById = (ctx) -> {
		String requestId = ctx.pathParam("request_id");
		List<request> requests = new ArrayList<request>();
		if (requestId != null) {
			requests.add(rdao.getRequest(Integer.parseInt(requestId)));
		}
		String json = gson.toJson(requests);
		ctx.result(json);
		ctx.status(200);
		log.info("get request by requestId");
	};
	
	public static Handler getRequestByAccountId = (ctx) -> {
		String accountId = ctx.pathParam("account_id");
		List<request> requests = new ArrayList<request>();
		if (accountId != null) {
			requests.addAll(rdao.getRequestByAccountId(Integer.parseInt(accountId)));
		}

		String json = gson.toJson(requests);
		ctx.result(json);
		ctx.status(200);
		log.info("get requests by accountId");
	};
	
	public static Handler getAllRequest = (ctx) -> {
		List<request> reimbursements = new ArrayList<request>();

		reimbursements = rdao.getAllRequest();

		String json = gson.toJson(reimbursements);
		ctx.result(json);
		ctx.status(200);
		log.info("get all requests");
	};

}
