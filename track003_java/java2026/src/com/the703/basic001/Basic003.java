package com.the703.basic001;

public class Basic003 {

	public static void main(String[] args) {
		//1. System.out.println(); 줄바꿈o
		System.out.println("Hello");
		
		//2. System.out.print(); 줄바꿈x
		System.out.print("A\t");	// \t - tap키 누른효과
		System.out.print("B\n");
		System.out.print("a\t");
		System.out.print("b\n");	// \n - 줄바꿈
		
		//3. System.out.printf("%s%d" ,"문자열","숫자" ); 
		// printf -> 출력서식
		// %d 숫자, 정수 ,1 2 3
		// %s 문자열, "abc" 
		System.out.printf("%d 더하기 %d 은 %s \n", 1, 1, "귀요미");
		System.out.printf("%s하면 %d\n", "궁금", 500);
			
		System.out.println();
		
		//4. +의 의미
		System.out.println(10+3);
		System.out.println(10+"3");
		System.out.println("10"+3);
		
		System.out.println("10 + 3 = " + (10+3)); //1. 오류 없애기 2. 결과물 10+3=13
		System.out.println("10 + 3" + " = " + (10+3));
	}

}
