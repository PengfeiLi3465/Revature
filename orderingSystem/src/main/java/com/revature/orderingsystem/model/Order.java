package com.revature.orderingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "`order`",schema = "project2")
//@Data
//public class Order {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	private int orderId;
//
//	private int userId;
//
//	private int conditiontypeId;
//
//	private float totalPrice;
//
//	private String orderNote;
//
//}
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	@Column(name="user_id")
	private int userId;
	@Column(name="conditiontype_id")
	private int conditiontypeId;
	@Column(name="total_price")
	private float totalPrice;
	@Column(name="order_note")
	private String orderNote;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, int userId, int conditiontypeId, float totalPrice, String orderNote) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.conditiontypeId = conditiontypeId;
		this.totalPrice = totalPrice;
		this.orderNote = orderNote;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getConditiontypeId() {
		return conditiontypeId;
	}
	public void setConditiontypeId(int conditiontypeId) {
		this.conditiontypeId = conditiontypeId;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderNote() {
		return orderNote;
	}
	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", conditiontypeId=" + conditiontypeId
				+ ", totalPrice=" + totalPrice + ", orderNote=" + orderNote + "]";
	}

}