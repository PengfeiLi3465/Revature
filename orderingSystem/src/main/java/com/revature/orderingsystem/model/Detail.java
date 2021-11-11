package com.revature.orderingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "detail",schema = "project2")
//@Data
//public class Detail {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	private int detailId;
//
//	private int orderId;
//
//	private int itemId;
//
//	private int itemAccount;
//
//}
public class Detail{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detail_id")
	private int detailId;
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "item_account")
	private int itemAccount;
	
	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Detail(int detailId, int orderId, int itemId, int itemAccount) {
		super();
		this.detailId = detailId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemAccount = itemAccount;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemAccount() {
		return itemAccount;
	}

	public void setItemAccount(int itemAccount) {
		this.itemAccount = itemAccount;
	}

	@Override
	public String toString() {
		return "Detail [detailId=" + detailId + ", orderId=" + orderId + ", itemId=" + itemId + ", itemAccount="
				+ itemAccount + "]";
	}


}