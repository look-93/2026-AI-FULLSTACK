package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		double hab=0;
		String result = "";		
		char ch;
		
		System.out.print("정수를 하나 입력해주세요 > ");
		num1 = sc.nextInt();
		System.out.print("정수를 하나 입력해주세요 > ");
		num2 = sc.nextInt();		
		System.out.print("연산자를 입력해주세요 > ");
		ch = sc.next().charAt(0);		
		
		if(ch == '+') {
			hab = num1 + num2;
		}else if(ch == '-'){
			hab = num1 - num2;			
		}else if(ch == '*') {
			hab = num1 * num2;			
		}else if(ch == '/') {
			hab = (double)num1/num2;			
		}

		/* 나누기는 소수점 나오게 */
		System.out.printf("%d %s %d = %.2f", num1, ch, num2, result);
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