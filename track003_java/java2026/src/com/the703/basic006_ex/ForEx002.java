package com.the703.basic006_ex;

import java.util.Scanner;

public class ForEx002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int gugu=0;
		
		System.out.print("원하는 '단'을 입력해주세요!(1~9) > ");
		gugu = sc.nextInt();
		
		for(int i=1;i<=9;i++) {
			System.out.println(gugu + "*" + i + "=" + gugu*i);
		}	

	}

}

//연습문제2)  
//패키지명 : com.company.java005_ex
//클래스명 :  ForEx002
//출력내용 :   for 이용
//
//   사용자에게 단을 입력받아 해당하는 
//   단을 출력해주는 프로그램을 작성하시오. FOR문을 이용하시오.
