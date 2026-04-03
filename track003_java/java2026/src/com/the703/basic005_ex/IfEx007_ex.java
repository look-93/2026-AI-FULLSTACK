package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007_ex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char ch = '\u0000';

		
		System.out.print("정수를 하나 입력해주세요 > ");
		num1 = sc.nextInt();
		System.out.print("정수를 하나 입력해주세요 > ");
		num2 = sc.nextInt();		
		System.out.print("연산자를 입력해주세요 > ");
		ch = sc.next().charAt(0);		
		
		String result = "" + num1 + ch + num2 + "=";
		
		if(ch == '+') {
			result += (num1+num2);
		}else if(ch == '-'){
			result += (num1-num2);
		}else if(ch == '*') {
			result += (num1*num2);
		}
		else if(ch == '/') {
			result += String.format("%.2f", num1/(double)num2);
		}	
		
		System.out.print(result);
		
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