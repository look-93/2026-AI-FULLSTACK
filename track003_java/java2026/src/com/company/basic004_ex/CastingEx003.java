package com.company.basic004_ex;

import java.util.Scanner;

public class CastingEx003 {

	public static void main(String[] args) {
		// 1. 문자는 저장시 숫자저장/ 출력시 문자
		System.out.println("1." + 'A' + "\t" + (int)'A'); //1.A	65, 'A' 문자
		System.out.println("2." + 'a' + "\t" + (int)'a'); //2.a	97, "ABC" 문자열
		System.out.println("3." + "ABC".charAt(0));
		System.out.println("4." + "ABC".charAt(1));
		
		// - 대문자입력받아서 소문자로 변경프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		char ch='\u0000', lower='\u0000';
		
		System.out.println("대문자입력 > ");
		ch = sc.next().charAt(0);
		
		//a(97) = A(65) + 32
		//char 	= char 	+ int
		//2byte = 2byte + 4byte
		//강제형변환
		lower = (char) (ch + 32);
		System.out.println(ch + "를 소문자로 " + lower );
	}

}

//연습문제3)
//패키지명 : com.the703.basic004_ex
//클래스명 : CastingEx003
//- 대문자입력받아서 소문자로 변경프로그램을 작성하시오.