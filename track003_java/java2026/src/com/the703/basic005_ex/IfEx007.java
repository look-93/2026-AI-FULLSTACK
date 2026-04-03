package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
//		double sum = 0;
		char ch;
		String result = "";		
		
		System.out.print("정수를 하나 입력해주세요 > ");
		num1 = sc.nextInt();
		System.out.print("정수를 하나 입력해주세요 > ");
		num2 = sc.nextInt();		
		System.out.print("연산자를 입력해주세요 > ");
		ch = sc.next().charAt(0);		
		
		//방법 1.
		if(ch == '+') {
			result = (num1+num2)+"";
		}else if(ch == '-'){
			result = (num1-num2)+"";		
		}else if(ch == '*') {
			result = (num1*num2)+"";			
		}
		else if(ch == '/') {
			result = String.format("%.2f", num1/(double)num2); // 소수점 둘째자리까지
			result = result+"";		
		}	
		
		System.out.printf("%d %s %d = %s", num1, ch, num2, result);
		
		//방법 2.
//		if(ch == '+') {
//			sum = num1+num2;
//			result = String.valueOf(sum);
//		}else if(ch == '-'){
//			sum = num1-num2;
//			result = String.valueOf(sum);	
//		}else if(ch == '*') {
//			sum = num1*num2;
//			result = String.valueOf(sum);			
//		}
//		else if(ch == '/') {			
//			sum = (double)num1/num2;	
//			result = String.format("%.2f", sum);
//			result = String.valueOf(result);
//		}	

		System.out.printf("%d %s %d = %s", num1, ch, num2, result);
	}

}

//연습문제7)  ※ 숙제
//패키지명 : com.company.java004_ex
//클래스명 :  IfEx007
//출력내용 :  계산기
//
//1. 정수를 하나 입력해주세요 > 10
//2. 정수를 하나 입력해주세요 > 3
//3. 연산자를 입력해주세요(+,-,*,/) > +
//10+3=13

//※나누기는 소수점 둘째자리까지