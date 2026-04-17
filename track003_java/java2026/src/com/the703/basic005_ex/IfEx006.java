package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx006 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		String st = "홀수"; 
		
		System.out.println("숫자를 입력하세요 > ");
		num = sc.nextInt();
		
		//1형식
		if(num % 2 == 0) {
			st = "짝수";			
		}
		System.out.println(st);
		
		//2형식
		if(num % 2 == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		
		//삼항연산자
		System.out.println(num % 2 == 0 ? "짝수" : "홀수");
		
		
	}

}

//연습문제6)
//패키지명 : com.company.java004_ex
//클래스명 :  IfEx006
//출력내용 : 숫자를입력을받아
//   홀수면 남자, 짝수면 여자를 출력하는 프로그램을 작성하시오.
//   ※  num%2==0  짝수