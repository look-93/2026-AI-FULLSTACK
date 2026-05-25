package com.the703.v5_burger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Kiosk {
	Scanner sc = new Scanner(System.in);
	Map<Integer, Item> burger = new HashMap<>(); // 버거
	Map<Integer, Item> drink = new HashMap<>();  // 음료
	List<Item> cart = new ArrayList<>(); // 장바구니
	
	public Kiosk() {		
		burger.put(1, new Burger("빅맥", 5500));
		burger.put(2, new Burger("상하이버거", 4500));	
		burger.put(3, new Burger("불고기버거", 3000));	
		burger.put(4, new Burger("치즈버거", 3500));	
		burger.put(5, new Burger("베이컨토마토디럭스", 6500));
		
		drink.put(1, new Drink("콜라", 1200));
		drink.put(2, new Drink("사이다", 1200));		
	}

	public void startKiosk() { // 키오스크 시작
		String answer;
		int categoryNum;
		Item menu;
		
		do {
			categoryNum = showCategory();
			menu        = showMenu(categoryNum);	
			answer      = addCart(menu);			
		}while(answer.equals("y"));
		
		if(answer.equals("n")) {
			System.out.println("주문하기로 이동합니다.");
			order();		
		}
	}

	public Integer showCategory() { // 카테고리 조회		
		int categoryNum = -1;
		
		System.out.println("╔══════════════════════╗");
		System.out.println("      CATEGORY MENU     ");
		System.out.println("╚══════════════════════╝");
		System.out.println("1. 🍔 햄버거");
		System.out.println("2. 🥤 음료");
		System.out.println("────────────────────────");
		System.out.print("👉 카테고리 선택 : ");
		categoryNum = sc.nextInt();
		
//		if(categoryNum <= 0 || categoryNum >= 4) {
//			System.out.println("번호를 확인하세요.");
//			return 0;			
//		}		
		return categoryNum;
	}
	
	public Item showMenu(int categoryNum) { // 카테고리메뉴 1.버거, 2.음료
		int menuNum = 0;
		System.out.println();
		if(categoryNum == 1) {		
			showItem(burger);
		}else if(categoryNum == 2) {
			showItem(drink);
		}		
		System.out.println();
		System.out.print("👉 주문할 메뉴 번호 : ");		
		menuNum = sc.nextInt();
		
		return categoryNum == 1 ? burger.get(menuNum) : drink.get(menuNum); 
	}
	
	public String addCart(Item menu) {
		cart.add(menu);
		String answer="";
		
		System.out.println();
		System.out.print("장바구니에 " + cart.size() + "개 담겼습니다.\n👉 추가 하시겠습니까? (y/n) : ");
		answer = sc.next();
		
		System.out.println();
		return answer;		
	}
	
	public void order() {
		int cnt = 0;
		int sum = 0;
		
		System.out.println("╔══════════════════════╗");
		System.out.println("       🍔 주문 확인 🥤    ");
		System.out.println("╚══════════════════════╝");

		for(Item cart : cart) {
			System.out.println(++cnt + ". name : " + cart.getName() + ", price : " + cart.getPrice());
			sum += cart.getPrice();
		}
		
		System.out.println("👉 총 : " + cart.size() + "개");
		System.out.println("👉 합 계 : " + sum + "원");
		
	}	
	
	private void showItem(Map<Integer, Item> items) {
		for(Entry<Integer, Item> item: items.entrySet()) {
			System.out.println(" "  
							 + item.getKey() + " " 
						     + item.getValue().getName() + "	" 
						     + item.getValue().getPrice()      + "원");
		}			
	}
	
	public static void main(String[] args) {		
		Kiosk kiosk = new Kiosk();
		kiosk.startKiosk();
		
	}	
}
