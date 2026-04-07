package com.the703.basic006_ex;

public class ForEx001 {

	public static void main(String[] args) {
		//q1  for문을 이용해서 다음과 같이 출력하시오 :   1 2 3 4 5
		for(int i=1;i<=5;i++) {
			System.out.print(i+"\t");
		}
		System.out.println();
		//q2  for문을 이용해서 다음과 같이 출력하시오 :   5 4 3 2 1 
		for(int i=5;i>=1;i--) {
			System.out.print(i+"\t");
		}
		System.out.println();
		//q3  for문을 이용해서 다음과 같이 출력하시오 :   JAVA1 , JAVA2 , JAVA3  
		for(int i=1;i<=3;i++) {
			System.out.print((i==1?"":",")+"JAVA"+i+"\t");
		}
		System.out.println();
		
		//q4  for문을 이용해서 다음과 같이 출력하시오 :   HAPPY3 ,HAPPY2, HAPPY1  		
		for(int i=3;i>=1;i--) {
			System.out.print("HAPPY"+i+"\t");
		}
		System.out.println();		
		
		//q5  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2  
		for(int i=0;i<=2;i++) {
			System.out.print(i+"\t");
		}
		System.out.println();	
		
		//q6  for문을 이용해서 다음과 같이 출력하시오 :   0,1,2, ,,,중간생략 ,,, 99 
		for(int i=0;i<=99;i++) {
			System.out.print(i+"\t");
		}
		System.out.println();
		
		//q7  for문을 이용해서 다음과 같이 출력하시오 :   10, 9,,,,중간생략 ,,, , 1 		
		for(int i=10;i>=1;i--) {
			System.out.print(i+"\t");
		}
		System.out.println();
		
		//q8  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 
		for(int i=0;i<=8;i+=2) {
			System.out.print(i+"\t");
		}
		System.out.println();		
		//q9  for문을 이용해서 다음과 같이 출력하시오 :   0, 2, 4, 6, 8 ,,,중간생략 ,,, 18 
		for(int i=0;i<=18;i+=2) {
			System.out.print(i+"\t");
		}
		System.out.println();	
	}

}






 


