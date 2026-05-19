package com.the703.v5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class BurgerHouse{
	private int orderNumber = 0; 	// 주문번호
	private int  menuNum = -1;		// 메뉴리스트 번호
	private String answer = "";		// 응답(y/n)
	Scanner sc = new Scanner(System.in);
	
	// 햄버거 메뉴
	List<Burger> menus = new ArrayList<>();
	
	//조리대기
	Map<Integer, List<Integer>> waitingList = new HashMap<>();	
	//조리중
	Map<Integer, List<Integer>> cookingList = new HashMap<>();
	//조리완료
	Map<Integer, List<Integer>> cookingCompleted = new HashMap<>();
	
	Runnable runnable = new Runnable() {

		@Override
		public void run() {

			while(true) {
				try {
					Thread.sleep(1000);
					Integer key = waitingList.keySet().iterator().next();
					if(key!=null) {						
						cookingList.put(key, waitingList.get(key));
						waitingList.remove(key);
						Integer cookingTargetKey = cookingList.keySet().iterator().next();
						List<Integer> burgerIds = cookingList.get(cookingTargetKey);
						for (Iterator iterator = burgerIds.iterator(); iterator.hasNext();) {
							Integer id = (Integer) iterator.next();
							Burger foundBuger = menus
									.stream()
									.filter(menu->menu.getBurgerId() ==id)
									.findFirst()
									.orElse(null);
							try {
								Thread.sleep(foundBuger.getTime());
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
						}

					}
					
					
					//1초마다 한번씩 웨이팅리스트에 있으면 쿠킹리스트로 옮기고
					//쿠킹리스트에 있는걸 꺼내서 시간초만큼 보낸다음 쿠킹컴플리트로 보낸다
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 	
			}
			
		} // end run;
		
	}; // end runnable
	
	
	public BurgerHouse() {	
		menus.add(new Burger(1, "더조은버거", 1000, "시그니처 버거!", 4000, false));
		menus.add(new Burger(2, "불고기버거", 1500, "달달한 불고기 소스가 들어간 한국식 햄버거!", 4000, false));		
		menus.add(new Burger(3, "치즈버거", 1200, "기본 햄버거에 치즈 추가, 클래식 버거", 4000, false));
		menus.add(new Burger(4, "징거버거", 1600, "바삭한 치킨 패티에 살짝 매콤한 맛이 특징!", 4000, true));
		menus.add(new Burger(5, "새우버거", 1400, "탱글한 식감, 해산물 향 가득~", 4000, true));
		menus.add(new Burger(6, "가자미버거", 1300, "가자미를 튀긴 담백한 버거", 4000, true));	
		
		System.out.println( "╔══════════════════════╗ \n"
				  		  + "     BURGER HOUSE        \n"
				  		  + " 	  OPEN                \n"
				  		  + "╚══════════════════════╝"
				  		  );
	}
	
	public void showMenu() {
		
	    System.out.print ( "╔══════════════════════╗ \n"
	    				 + "║      MENU LIST       ║ \n"
	    				 + "╚══════════════════════╝ \n"
	    				 + "1. 주문하기	\n"
	    				 + "2. 메뉴 상태 확인(조리중/대기중/취소/완료)	\n"
	    				 + "3. 취소하기	\n"
	    				 + "9. 종료		\n"
	    				 + "▶ 메뉴 선택 : ");
	}

	public void sales() { // 매출조회
		// TODO Auto-generated method stub
		
	}

	public void workStart() {
		// TODO Auto-generated method stub
		
	}

	public void storeOpen() { // 가게 오픈
		int menu = -1;
		
		while(menu != 9) {
			showMenu();
			menu = sc.nextInt();
			
			if (menu == 9) {
				System.out.println("종료기능입니다.");
				break;
			}else if(menu == 1) {
				order();
				break;
			}else if(menu == 2) {
				checkingOrder();
				break;
			}else if(menu == 3) {
				orderCancel();
				break;
			}else {
				return;
			}
			
		}
		
	}


	public void order() { // 주문하기
		//order.burgerIds - 장바구니리스트
		//주문하실 메뉴를 고르세요.
		//선택
		//더 주문하시겠습니까?
		//예/아니오
		//아니오시 -> 몇개()메뉴를 주문하시겠습니까?
		//예/취소 -> 취소 -> 그냥종료 / 예-> 주문대기에 넣고 주문번호 주고 종료 orderNumber++
		Order order = new Order();
		List<Integer> bugerIds = new ArrayList<>();
		
		do {
			showMenus();
			System.out.print("🍔 어떤 버거를 드시겠어요? (취소:999) > ");
			menuNum = sc.nextInt();
			
			if(menuNum == 999) {
				System.out.println("주문 취소 하셨습니다. 메뉴리스트로 이동합니다.");
				storeOpen();
				return;
			}
			
			bugerIds.add(menuNum);
			System.out.print("더 추가하시겠습니까? (y/n)> ");
			answer = sc.next();
			
		}while(answer.equals("y"));
		
		if(menuNum == 999) {storeOpen(); return;}
		
		System.out.print("장바구니에" + bugerIds.size() + "건 담겼습니다. \n주문하시겠습니까? (y/n)");
		answer = sc.next();
		
		if(answer.equals("y")) {
			order.setOrderNumber(++orderNumber);	
			waitingList.add(order);	
			System.out.println(bugerIds.size() + "개 주문 완료! \n" 
							 + "주문번호 : " + orderNumber
							  );
		}else {			
			System.out.println("주문 취소 하셨습니다. 메뉴리스트로 이동합니다.");			
		}
		storeOpen();
	}

	public void orderCancel() { // 주문취소
		System.out.println("🍔 주문 취소 하기");
		
		System.out.print("주문번호를 입력하세요. > ");
		orderNumber = sc.nextInt();
		
		// 조리대기 리스트에 있으면 취소
		System.out.println(waitingList.size());
		List<Integer> orderKeys = waitingList.stream().map(order->order.getOrderNumber()).toList();
		if(orderKeys.contains(orderNumber)) {
			System.out.print("정말 주문 취소하시겠습니까? (y/n) ");
			answer = sc.next();
			
			if(answer.equals("n")) {
				System.out.println("기존 주문이 유지됩니다.");
			}else {
				System.out.println("정상 취소 되었습니다.");
				waitingList.remove(menuNum)
			}			
		}//else if (){// 조리중 리스트에 있으면 취소불가 조리중입니다.}
		//else if (){// 조리완료 리스트에 있으면 취소불가 조리완료되었습니다.}
		System.out.println(waitingList.size());
		storeOpen();
	}

	public void checkingOrder() { // 메뉴 상태 확인
		// TODO Auto-generated method stub
		
	}

	public void showMenus() { // 버거메뉴판
		for(int i=0; i<menus.size(); i++) {
		System.out.println(menus.get(i).getBurgerId()   + ". " 
					     + menus.get(i).getBurgerName() + " \n"
					     + "가격 : " + menus.get(i).getPrice() + " \n"
					     + "버거설명 : " + menus.get(i).getMenuDscription() + " \n"
					     + "vegan : " + menus.get(i).getVegan() + " \n"
					     + "조리시간 : " + menus.get(i).getTime() + " \n"
						  );
		}
	}	
	
	
}
