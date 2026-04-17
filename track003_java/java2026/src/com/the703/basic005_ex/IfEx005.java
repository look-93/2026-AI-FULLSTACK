package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx005 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch;
		
		System.out.println("문자를 한개 입력하세요");
		ch = sc.next().charAt(0);
		
		System.out.println(ch >= 'A' && ch <= 'Z' ? (char)(ch + 32) : ch >= 'a' && ch <= 'z' ? (char)(ch - 32) : "둘다 아니다");
		
		if(ch >= 'A' && ch <= 'Z') {
			ch = (char)(ch + 32);
//			System.out.println(ch);
		}else if(ch >= 'a' && ch <= 'z'){
			ch = (char)(ch - 32);
//			System.out.println(ch);			
		}
		System.out.println(ch);	
	}

}

//연습문제5)
//패키지명 : com.company.java004_ex
//클래스명 :  IfEx005
//출력내용 : 문자한개를 입력받아 
//   대문자인지 이면 소문자로,  소문자이면 대문자로 변경하는 프로그램을 작성하시오.
//   ※  a = 'A' + 32    