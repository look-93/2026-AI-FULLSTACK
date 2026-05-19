package com.the703.v5;

import java.util.List;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(orderNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return orderNumber == other.orderNumber;
	}	
	
	
}
