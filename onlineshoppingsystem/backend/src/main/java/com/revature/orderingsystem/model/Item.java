package com.revature.orderingsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Entity
@Table(name="item", schema="project2")
//@Data
//public class Item {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	private int itemId;
//
//	private String itemName;
//
//	private float itemPrice;
//}
public class Item{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_id")
	private int itemId;
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_price")
	private float itemPrice;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int itemId, String itemName, float itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemPrice=" + itemPrice + "]";
	}
	
	
}