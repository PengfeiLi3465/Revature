package com.revature.reimbursementSystem.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.reimbursementSystem.controller.accountController;
import com.revature.reimbursementSystem.controller.requestController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {

	public static void main(String[] args) throws Exception {

		Logger log = LoggerFactory.getLogger(App.class);

		Javalin app = Javalin.create(config -> {
			config.addStaticFiles("/public", Location.CLASSPATH);
		}).start(7050);
		log.info("app is stating here");
		app.get("/accounts", accountController.getAllAccount);
		app.post("/request", requestController.createRequest);
		app.get("/request/:request_id", requestController.getRequestById);
		app.get("/requestA/:account_id", requestController.getRequestByAccountId);
		app.get("/requests", requestController.getAllRequest);
		app.put("/request", requestController.updateRequest);

	}

}