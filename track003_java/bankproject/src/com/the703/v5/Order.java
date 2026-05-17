package com.the703.v5;

import java.util.List;

public class Order {
	private int orderNumber;
	private List<Integer> burgerIds;
	
	public Order() {
		super();
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public List<Integer> getBurgerIds() {
		return burgerIds;
	}
	public void setBurgerIds(List<Integer> burgerIds) {
		this.burgerIds = burgerIds;
	}	
}
