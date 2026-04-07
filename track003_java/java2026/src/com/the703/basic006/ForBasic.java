package com.the703.basic006;

public class ForBasic {

	public static void main(String[] args) {
		//step1) 줄바꿈 안된 print 이용해서 1 2 3
		System.out.println("STEP1) 출력");
		System.out.print("1");
		System.out.print("2");
		System.out.print("3");
		
		System.out.println("\nSTEP2) for");
		//for(;;){빠져나올조건
		//step2-1) 반복되는 영역 			System.out.print("1");
		//step2-2) 반복되는 영역-> 변수찾기 	System.out.print(1,2,3으로 바뀜);
		//step2-3) 패턴찾기 (초기값;조건문;증감문)	시작1, 종료3, 증감1
		for(int i=1; i<=3; i++) {
			System.out.print(i);
		}	
		
		//step3)
		System.out.println("\nSTEP3) for 연습");
		
		//패턴:시작1; 종료10; 변화1
		for(int i=1; i<=10; i++) {
			System.out.print(i);
		}
		System.out.println();
		
		//패턴:시작2; 종료8; 변화1
		for(int i=2; i<=8; i++) {
			System.out.print(i);
		}
		System.out.println();	
		
		//패턴:시작3; 종료9; 변화3
		for(int i=3; i<=9; i+=3) {
			System.out.print(i);
		}
		System.out.println();
		
		//패턴:시작5; 종료1; 변화-2
		for(int i=5; i>=1; i-=2) {
			System.out.print(i);
		}
		System.out.println();		
		
		//Hi1 Hi2 Hi3
		for(int i=1; i<=3; i++) {
			System.out.print("Hi"+i+"\t");
		}
	}

}
