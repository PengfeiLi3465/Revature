package com.revature.reimbursementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.revature.reimbursementSystem.dao.accountDao;
import com.revature.reimbursementSystem.dao.accountDaoImp;
import com.revature.reimbursementSystem.model.account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.javalin.http.Handler;

public class accountController {
	private static accountDao adao = new accountDaoImp();
	private static Gson gson = new Gson();
	private static Logger log = LoggerFactory.getLogger(accountController.class);

	public static Handler getAllAccount = (ctx) -> {
		List<account> accounts = new ArrayList<account>();
		accounts = adao.getAllAccount();
		String json = gson.toJson(accounts);
		ctx.result(json);
		ctx.status(200);
		log.info("get all account");
	};
}
