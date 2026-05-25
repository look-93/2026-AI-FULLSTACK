package com.the703.v5_burger.service;

import java.util.Map;

import com.the703.v5_burger.dto.Item;

public interface Kiosk {
	Integer showCategory();
	Item showMenu(int categoryNum);
	String addCart(Item menu);
	void order();
	public void showItem(Map<Integer, Item> items);
	public void sendItem();
}
