package com.the703.v5_burger.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.the703.v5_burger.dto.Burger;
import com.the703.v5_burger.dto.Drink;
import com.the703.v5_burger.dto.Item;

import java.util.Scanner;

public class KioskImpl implements Kiosk {
	Scanner sc = new Scanner(System.in);
	Map<Integer, Item> burgers = new HashMap<>(); // 버거
	Map<Integer, Item> drinks = new HashMap<>(); // 음료
	List<Item> carts = new ArrayList<>(); // 장바구니

	BufferedReader in = null;
	PrintWriter out = null;
	Socket socket = null;

	public KioskImpl() {
		burgers.put(1, new Burger("빅맥", 5500));
		burgers.put(2, new Burger("상하이버거", 4500));
		burgers.put(3, new Burger("불고기버거", 3000));
		burgers.put(4, new Burger("치즈버거", 3500));
		burgers.put(5, new Burger("베이컨토마토디럭스", 6500));

		drinks.put(1, new Drink("콜라", 1200));
		drinks.put(2, new Drink("사이다", 1200));

		try {
			socket = new Socket("127.0.0.1", 5001);
			// 입력스트림
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 아웃풋스트림
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
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

	@Override
	public Item showMenu(int categoryNum) { // 카테고리메뉴 1.버거, 2.음료
		int menuNum = 0;
		System.out.println();
		if (categoryNum == 1) {
			showItem(burgers);
		} else if (categoryNum == 2) {
			showItem(drinks);
		}
		System.out.println();
		System.out.print("👉 주문할 메뉴 번호 : ");
		menuNum = sc.nextInt();

		return categoryNum == 1 ? burgers.get(menuNum) : drinks.get(menuNum);
	}

	@Override
	public String addCart(Item menu) {
		carts.add(menu);
		String answer = "";

		System.out.println();
		System.out.print("장바구니에 " + carts.size() + "개 담겼습니다.\n👉 추가 하시겠습니까? (y/n) : ");
		answer = sc.next();

		System.out.println();
		return answer;
	}

	@Override
	public void order() {
		int cnt = 0;
		int sum = 0;

		System.out.println("╔══════════════════════╗");
		System.out.println("       🍔 주문 확인 🥤    ");
		System.out.println("╚══════════════════════╝");

		for (Item cart : carts) {
			System.out.println(++cnt + ". name : " + cart.getName() + ", price : " + cart.getPrice());
			sum += cart.getPrice();
		}

		System.out.println("👉 총 : " + carts.size() + "개");
		System.out.println("👉 합 계 : " + sum + "원");

	}

	@Override
	public void showItem(Map<Integer, Item> items) {
		for (Entry<Integer, Item> item : items.entrySet()) {
			System.out.println(
					" " + item.getKey() + " " + item.getValue().getName() + "	" + item.getValue().getPrice() + "원");
		}
	}

	@Override
	public void sendItem() {

		for (Item cart : carts) {
			String type = cart instanceof Burger ? "burger" : "drink";
			String requestCsv = cart.getName() + "," + cart.getPrice() + "," + type;
			out.println(requestCsv);
//			System.out.println("발신완료" + requestCsv);
		}
		carts.clear();
	}

}
