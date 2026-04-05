package com.the703.basic004_ex;

import java.util.Scanner;

public class CastingEx001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		double result;
		
		System.out.print("숫자입력1> ");
		num1 = sc.nextInt();
		System.out.print("숫자입력2> ");
		num2 = sc.nextInt();
		
		
		result = num1 / num2;
		System.out.println("결과는? " + result);
		result = num1 / (double) num2;
		System.out.println("결과는? " + result);
		System.out.printf("결과는? %d / %d = %.2f" , num1 , num2 ,result );
//		result = (double) num1 / num2;
//		System.out.println("결과는? " + result);
//		result = (double) num1 / (double) num2;
//		System.out.println("결과는? " + result);
	}

}


//연습문제1)
//패키지명 : com.company.java003_ex
//클래스명 : CastingEx001
//출력내용 :  Scanner이용해서 나누기 프로그램만들기 
//   숫자입력1>  _입력받기  10   ( ☆자료형을 int )
//   숫자입력2>  _입력받기  3     ( ☆자료형을 int )              
//   
//   10 / 3 = 3.33
//
//주어진조건 : 
//      //변수
//      int num1, num2;
//      double result;
//      Scanner scanner = new Scanner(System.in);
//
//   1단계)  변수 - 입력- 처리 - 출력
//   2단계)  정수/정수 = 정수
//              정수/실수 = 실수
//              실수/정수 = 실수
//              실수/실수 = 실수    
//      ※  형변환법 :    by = (byte) in;   나 잠깐만 byte할게.... 데이터 누수있을수 있음!
//          