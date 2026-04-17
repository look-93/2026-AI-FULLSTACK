package com.the703.basic005;

public class If001 {

	public static void main(String[] args) {
		//1. 형식 axe가 1이라면 금도끼, 2라면 금도끼, 3이라면 낡은도끼
		// if(조건){ 참결과 }
		System.out.println("■ 1형식 - 조건을 무조건 읽음");
		int axe = 1;
		
		if(axe == 1) {
			System.out.println("금도끼");
		}
		if(axe == 2) {
			System.out.println("은도끼");
		}
		if(axe == 3) {
			System.out.println("낡은도끼");
		}
		
		//2형식 if(axe 가 1이라면){금도끼}else{아니라면 다른거}
		System.out.println("■ 2형식 - 맞다/틀리다 둘중에 하나");
		axe = 2;
		if(axe == 1) {
			System.out.println("금도끼");
		}else {
			System.out.println("내도끼 아니다");
		}
		
		//다형식
		System.out.println("■ 다형식 - 여러조건");
		// 		if (axe가 1라면){금도끼}
		// else if (axe가 2라면){은도끼}
		// else if (axe가 3라면){낡은도끼}
		// else 			  {내도끼 아니다}
		if(axe == 1) {
			System.out.println("금도끼");
		}else if(axe == 2) {
			System.out.println("은도끼");
		}else if(axe == 3) {
			System.out.println("낡은도끼");
		}else {
			System.out.println("내도끼 아니다");
		}
	}

}
