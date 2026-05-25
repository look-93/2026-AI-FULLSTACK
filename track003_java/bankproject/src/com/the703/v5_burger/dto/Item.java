package com.the703.v5_burger.dto;

public class Item { // implements Serializable (단점:많이안씀 버전충돌,느림,,,,,,, 탈락...)
	//직렬화와 역질렬화간 객체의 버전 확인 
	//ex) 내PC 객체와 다른PC의 객체가 같은지 확인
	//private static final long serialVersionUID = 1L;  
	
	private String name;
	private int price;

	public Item() {
		super();
	}
	
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
