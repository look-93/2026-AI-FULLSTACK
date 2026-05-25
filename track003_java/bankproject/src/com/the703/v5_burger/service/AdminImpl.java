package com.the703.v5_burger.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.the703.v5_burger.dto.Burger;
import com.the703.v5_burger.dto.Drink;
import com.the703.v5_burger.dto.Item;

public class AdminImpl implements Admin {
	Scanner sc = new Scanner(System.in);
	
	List<Item> items = new ArrayList<>();

	@Override
	public Integer showCategory() { // 카테고리 조회
		int categoryNum = -1;

		System.out.println("╔══════════════════════╗");
		System.out.println("      📋 관리자 메뉴      ");
		System.out.println("╚══════════════════════╝");
		System.out.println("1.💰 매출조회");
		System.out.println("2.🏆 카테고리 랭킹 조회");
		System.out.println("9. 종료");
		System.out.println("────────────────────────");
		System.out.print("👉 선택 : ");
		categoryNum = sc.nextInt();
		System.out.println();
		return categoryNum;
	}

	@Override
	public void showSales() {
		int sum = 0;

		System.out.println();
		System.out.println("╔══════════════════════╗");
		System.out.println("      💰 매출 확인 	    ");
		System.out.println("╚══════════════════════╝");

		for (int i = 0; i < items.size(); i++) {
			sum += items.get(i).getPrice();
		}

		System.out.println("총 주문 수 : " + items.size() + "건");
		System.out.println("총 매출액  : " + sum + "원");
		System.out.println();
	}

	@Override
	public void showCategoryRanking() {
		int cnt = 0;
		System.out.println("╔══════════════════════╗");
		System.out.println("      🏆 판매 랭킹        ");
		System.out.println("╚══════════════════════╝");
		
		List<Item> burger = items.stream()
				                 .filter(item -> item instanceof Burger)
				                 .collect(Collectors.toList());
		
		Collections.sort(burger, Comparator.comparingInt(Item::getPrice));

		Map<String, Long> rankingMap =
			    burger.stream()
			          .collect(Collectors.groupingBy(
			              Item::getName,
			              Collectors.counting()
			          ));
	
		
		if (items.size() == 0) {
			System.out.println("아직 등록된 매출이 없습니다.\n");
			return;
		}
		
		// String: name , long: co

		
		rankingMap.entrySet().stream()
	       .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
	       .forEach((ranking) -> {
	    	   System.out.println(ranking.getKey() + " " + ranking.getValue());
	       });

		System.out.println();

	}

	@Override
	public void run() {
		ServerSocket serverSocket;
		BufferedReader in = null;
		PrintWriter out = null;
		Socket socket = null;
		try {
//			System.out.println("수신대기");
			serverSocket = new ServerSocket(5001);

//			System.out.println("서버 시작");

			socket = serverSocket.accept(); // 5000번 포트로 들어오면 소켓이 하나 생김

			// 입력스트림
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//in = new ObjectInputStream(socket.getInputStream());  implements Serializable 사용
			// 아웃풋스트림
			out = new PrintWriter(socket.getOutputStream());

			while (true) {
				// Kiosk로부터 메시지받기
				String responseCsv = in.readLine();
//				System.out.println(responseCsv);
				if(responseCsv == null) {
					continue;
				}
//				System.out.println(responseCsv);
				String [] arr = responseCsv.split(",");
				String name = arr[0];
				int price = Integer.parseInt(arr[1]);
				String type = arr[2];
								
				if(type.equals("burger")) {
					items.add(new Burger(name,price));
				}else {
					items.add(new Drink(name,price));
				}				
		

				//Item item =(Item) in.readObject(); implements Serializable 사용시
				//받은 메시지를 역직렬화하여 아이템에 집어넣음
				//items.add(item);
				// 답장보내기
//				System.out.println("수신완료");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(in != null)in.close();
				if(out != null)out.close();
				if(socket != null && !socket.isClosed())socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
