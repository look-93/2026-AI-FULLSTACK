package com.the703.v5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BurgerHouse implements OrderInterface, KitchenInterface, AdminInterface{
	private int orderNumber = 0; // 주문번호
	Scanner sc = new Scanner(System.in);
	List<Burger> menus = new ArrayList<>();
	
	//조리대기
	List<Order> waitingList = new ArrayList<>();
	
	
	public BurgerHouse() {	
		menus.add(new Burger(1, "더조은버거", 1000, "시그니처 버거!", "4s", false));
		menus.add(new Burger(2, "불고기버거", 1500, "달달한 불고기 소스가 들어간 한국식 햄버거!", "4s", false));		
		menus.add(new Burger(3, "치즈버거", 1200, "기본 햄버거에 치즈 추가, 클래식 버거", "4s", false));
		menus.add(new Burger(4, "징거버거", 1600, "바삭한 치킨 패티에 살짝 매콤한 맛이 특징!", "4s", true));
		menus.add(new Burger(5, "새우버거", 1400, "탱글한 식감, 해산물 향 가득~", "4s", true));
		menus.add(new Burger(6, "가자미버거", 1300, "가자미를 튀긴 담백한 버거", "4s", true));	
		
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

	@Override
	public void sales() { // 매출조회
		// TODO Auto-generated method stub
		
	}

	@Override
	public void workStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
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


	@Override
	public void order() { // 주문하기
		Order order = new Order();
		int  menuNum = -1;
		String answer = "";
		List<Integer> bugerIds = new ArrayList<>(); 
		//order.burgerIds - 장바구니리스트
		//주문하실 메뉴를 고르세요.
		//선택
		//더 주문하시겠습니까?
		//예/아니오
		//아니오시 -> 몇개()메뉴를 주문하시겠습니까?
		//예/취소 -> 취소 -> 그냥종료 / 예-> 주문대기에 넣고 주문번호 주고 종료 orderNumber++
		
		showMenus();
		System.out.print("🍔 어떤 버거를 드시겠어요? > ");
		menuNum = sc.nextInt();
		bugerIds.add(menuNum);
		
		System.out.print("더 주문하시겠습니까? > ");
		answer = sc.next();
		if(answer.equals("y")) {
			showMenus();
			System.out.print("🍔 버거 추가 > ");
			menuNum = sc.nextInt();
			bugerIds.add(menuNum);
			order.setOrderNumber(++orderNumber);			
			order.setBurgerIds(bugerIds);
			waitingList.add(order);
			
			System.out.println(bugerIds.size() + "개 주문 완료! \n" 
							 + "주문번호 : " + orderNumber
							  );
			
			storeOpen();
			return;
		}else {
			System.out.print(bugerIds.size() + "개 주문 하시겠습니까? > "); 
			answer = sc.next();
			
			if(answer.equals("y")) {
				order.setOrderNumber(++orderNumber);
				order.setBurgerIds(bugerIds);			
				waitingList.add(order);
				
				System.out.println(bugerIds.size() + "개 주문 완료! \n" 
							     + "주문번호 : " + orderNumber
						          );
				
				storeOpen();
				return;
				
			}else {
				System.out.println("취소하셨습니다. \n메뉴 리스트로 이동합니다.");	
				storeOpen();
				return;
			}			
		}
	}

	@Override
	public void orderCancel() { // 주문취소
		// if (waitingList (조리대기)) {취소} else if (조리중) {조리중입니다} else if(주문완료) {주문완료되었습니다} 
		
	}

	@Override
	public void checkingOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
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
