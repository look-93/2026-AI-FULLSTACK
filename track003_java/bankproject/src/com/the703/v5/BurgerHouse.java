package com.the703.v5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BurgerHouse implements OrderInterface, KitchenInterface, AdminInterface{
	private int orderNumber = 0; // 주문번호
	
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
	public void sales() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void workStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storeOpen() {
		Scanner sc = new Scanner(System.in);
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
	public void order() {
		Order order = new Order();
		//order.burgerIds - 장바구니리스트
		showMenus();
		//주문하실 메뉴를 고르세요.
		//선택
		//더 주문하시겠습니까?
		//예/아니오
		//아니오시 -> 몇개()메뉴를 주문하시겠습니까?
		//예/취소 -> 취소 -> 그냥종료 / 예-> 주문대기에 넣고 주문번호 주고 종료 orderNumber++
		
	}

	@Override
	public void orderCancel() {
		// 
		
	}

	@Override
	public void checkingOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showMenus() {
		for(int i=0; i<menus.size(); i++) {
		System.out.println(menus.get(i).getBurgerId()   + ". \n" 
						 + menus.get(i).getBurgerName() + " "
						 + menus.get(i).getPrice() + " "
						 + menus.get(i).getMenuDscription() + " "
						 + menus.get(i).getVegan() + " "
						 + menus.get(i).getTime() + " "
						  );
		}
	}
	
}
