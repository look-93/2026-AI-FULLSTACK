package com.the703.basic010_ex;

//연습문제3)  멤버변수

//패키지명 : com.company.java010_ex
//클래스명 :  MemberVarEx003
//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기

/* [RUNTIME DATA AREA] 
------------------------------------------------------
[METHOD:정보, static, final] 
LunchTray.class 			 	MemberVarEx003.class #1

LunchTray.trayCount=0;  		LunchTray.totalFood=0;	LunchTray.maxRice = 100; 
LunchTray.showTrayCount();		LunchTray.showOwner();
------------------------------------------------------
[HEAP:동적]            												|  [STACK:지역]
2번지{owner =null ,rice=90, soup=85, getFoodAmount(),showTray()} 		<-		tray2(2번지)	
1번지{owner =null ,rice=90, soup=85, getFoodAmount(),showTray()} 	 	<-		tray1(1번지)		
																			main #2
------------------------------------------------------
(인스턴스)
*/

//- 문제 5. 다음과 같이 출력되도록 코드를 작성하시오.
//:: 주인 이름: std-1
//총 음식량: 175
//전체 급식판 수: 1

//:: 주인 이름: std-2
//총 음식량: 175
//전체 급식판 수: 2

class LunchTray {
	String owner; 	// 문제 1. 인스턴스변수 heap area
	int rice = 90; 	// 문제 1. 인스턴스변수 heap area
	int soup = 85; 	// 문제 1. 인스턴스변수 heap area

	static int trayCount = 0;					//문제 1. 클래스변수 method area
	static int totalFood; /*= rice + soup;*/ 	//문제 1. 클래스변수 method area  문제3)static은 인스턴스변수 (this)불가
	static int maxRice = 100;					//문제 1. 클래스변수 method area

	public int getFoodAmount() {
		return rice + soup;
	}//문제 2. 인스턴스메서드 heap area

	public static void showTrayCount() {
		System.out.println("전체 급식판 수: " + trayCount);
	}//문제 2. 클래스변수 method area

	public static void showOwner() {		
	 //System.out.println(owner); //문제3)static은 인스턴스변수 (this)불가
	}//문제 2. 클래스변수 method area 

	public void showTray() {
		System.out.println("\n\n:: 주인 이름: " + "std-" + ++trayCount);
		System.out.println("총 음식량: " + getFoodAmount());
	}//문제 2. 인스턴스메서드 heap area
}

public class MemberVarEx003 {
	public static void main(String[] args) {
		LunchTray tray1 = new LunchTray();
		tray1.showTray();
		LunchTray.showTrayCount();

		LunchTray tray2 = new LunchTray();
		tray2.showTray();
		LunchTray.showTrayCount();
	}
}
