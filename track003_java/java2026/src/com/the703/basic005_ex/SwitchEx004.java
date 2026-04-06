package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch;
		
		System.out.print("문자 한개 입력 > ");
		ch = sc.next().charAt(0);
		
		switch(ch) {
			case 'a': case 'A': System.out.println("APPLE");
			case 'b': case 'B': System.out.println("BANANA");
			case 'c': case 'C': System.out.println("COCONUT");
		}
	}

}

//연습문제4)  
//패키지명 : com.company.basic005_ex
//클래스명 :  SwitchEx004
//출력내용 :   switch 이용
//     문자한개 입력받아
//     a , A이면 APPLE
//     b , B이면 BANANA
//     c , C이면 COCONUT
