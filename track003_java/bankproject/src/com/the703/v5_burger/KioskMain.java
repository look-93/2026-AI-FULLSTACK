package com.the703.v5_burger;

import com.the703.v5_burger.dto.Item;
import com.the703.v5_burger.service.KioskImpl;
import com.the703.v5_burger.service.Kiosk;

public class KioskMain {

	public static void main(String[] args) {
		Kiosk kiosk = new KioskImpl();
		String answer;
		int categoryNum;
		Item menu;
		
		while(true) {
			do {
				categoryNum = kiosk.showCategory();
				menu = kiosk.showMenu(categoryNum);	
				answer = kiosk.addCart(menu);			
			}while(answer.equals("y"));
			
			if(answer.equals("n")) {
				System.out.println("주문하기로 이동합니다.");
				kiosk.order();		
				kiosk.sendItem();
			}
		}
	}

}
