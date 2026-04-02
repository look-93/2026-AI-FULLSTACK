package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.println("숫자를 입력해주세요 > ");
		num = sc.nextInt();
		if(num == 1) {
			System.out.println("one");
		}else if(num == 2) {
			System.out.println("two");
		}else if(num == 3) {
			System.out.println("three");
		}else {
			System.out.println("1,2,3이 아니다");
		}
		System.out.println(num == 1 ? "one" : num ==2 ? "two" : num ==3 ? "three" : "1,2,3이 아니다" );
	}

}


//연습문제3)
//패키지명 : com.the703.basic005_ex
//클래스명 :  IfEx003
//출력내용 : 숫자한개를 입력받아 
//   만약 1을 입력했다면   one ,   
//   만약 2을 입력했다면   two ,
//   만약 3을 입력했다면   three ,
//   1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.
 