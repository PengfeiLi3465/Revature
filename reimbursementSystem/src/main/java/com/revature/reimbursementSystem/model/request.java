package com.revature.reimbursementSystem.model;

public class request {
	private int request_id;
	private int account_id;
	private int conditiontype_id;
	private String description;
	private String note;
	private float amount;

	public request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public request(int request_id, int account_id, int conditiontype_id, String description, String note,
			float amount) {
		super();
		this.request_id = request_id;
		this.account_id = account_id;
		this.conditiontype_id = conditiontype_id;
		this.description = description;
		this.note = note;
		this.amount = amount;
	}

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getConditiontype_id() {
		return conditiontype_id;
	}

	public void setConditiontype_id(int conditiontype_id) {
		this.conditiontype_id = conditiontype_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "request [request_id=" + request_id + ", account_id=" + account_id + ", conditiontype_id="
				+ conditiontype_id + ", description=" + description + ", note=" + note + ", amount=" + amount + "]";
	}

}
