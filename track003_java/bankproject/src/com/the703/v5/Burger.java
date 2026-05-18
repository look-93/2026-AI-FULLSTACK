package com.the703.v5;

public class Burger {
	private int burgerId;
	private String burgerName;
	private double price;
	private String menuDscription;
	private int time;
	private boolean vegan;
	
	public Burger() {
		super();
	}

	public Burger(int burgerId, String burgerName, double price, String menuDscription, int time, boolean vegan) {
		super();
		this.burgerId = burgerId;
		this.burgerName = burgerName;
		this.price = price;
		this.menuDscription = menuDscription;
		this.time = time;
		this.vegan = vegan;
	}

	public int getBurgerId() {
		return burgerId;
	}

	public void setBurgerId(int burgerId) {
		this.burgerId = burgerId;
	}

	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getMenuDscription() {
		return menuDscription;
	}

	public void setMenuDscription(String menuDscription) {
		this.menuDscription = menuDscription;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public boolean getVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}	
}
