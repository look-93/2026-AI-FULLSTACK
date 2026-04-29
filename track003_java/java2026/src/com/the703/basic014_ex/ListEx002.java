package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> numbers = new ArrayList<>();
		int num=0;
		
		numbers.add("one");
		numbers.add("two");
		numbers.add("three");
	
		for(;;) {
			System.out.print("숫자를 입력하세요(1~3) > ");
			num = sc.nextInt();
			if(num==0) {System.out.println("종료");return;}
			if(num == 1) {
				System.out.println(numbers.get(0));
			}else if(num == 2) {
				System.out.println(numbers.get(1));
			}else if(num == 3) {
				System.out.println(numbers.get(2));
			}	
		}
	}
}

//연습문제2)  Collection  Framework
//패키지명 : com.company.java014_ex
//클래스명 : ListEx002
//1.  numbers ArrayList 만들기
//2.  one, two, three 데이터 추가
//3.  사용자에게 1,2,3 입력받기
//4.  1을 입력받으면 one 출력
//    2를입력받으면 two 출력
//    3을입력받으면 three 출력