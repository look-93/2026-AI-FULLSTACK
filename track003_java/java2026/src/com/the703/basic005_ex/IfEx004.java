package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch;
		
		System.out.println("문자 한개를 입력해주세요 > ");
		ch = sc.next().charAt(0);
		if(ch >='A' && ch <= 'Z'){
			System.out.println("대문자");
		}else if(ch>='a'&&ch<='z') {
			System.out.println("소문자");
		}
		
		System.out.println(ch >='A' && ch <= 'Z' ? "대문자" : ch>='a'&&ch<='z' ? "소문자" : "둘 다 아니다");

	}

}

//연습문제4)
//패키지명 : com.the703.basic005_ex
//클래스명 :  IfEx004
//출력내용 : 문자한개를 입력받아 
//   대문자인지,  소문자인지 판별하는 프로그램을 작성하시오.
//   ※  대문자  ch>='A' && ch<='Z' / 소문자  ch>='a'  &&  ch<='z'  
