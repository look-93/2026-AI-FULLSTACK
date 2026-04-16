package com.the703.days;

public class Day015 { 
	public static void main(String[] args) {
		//1		
		for(int i=3;i>=1;i--) {
			System.out.print(i);
		}
		System.out.println();
		
		int i2=3;
		while(i2>=1){
			System.out.print(i2);
			i2--;
		}
		System.out.println();
		
		int i3=3;
		do {
			System.out.print(i3);
			i3--;			
		}while(i3>=1);
		System.out.println();
		
		//2
		for(int i=1;i<=3;i++) {
			for(int j=3;j>=i;j--) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		//3
		char [] arr = new char[3];
		char ch = 'A';
		for(int i=0;i<=2;i++) {
			arr[i] = ch++;
			System.out.print(arr[i]);
		}			
		
		
	}
}

//■2. JAVA
//1.  for, while , do while을 이용해서 문제를 풀으시오.
//   3   2   1
//
//2 이중 for 버전
//다음과 같은 모양을 출력하는 프로그램을 작성하시오.
//★★★
//★★
//★
//
//3.  1차원배열      new 연산자 이용해서 배열만들기
//  1. 배열명 : arr     
//  2. 값 넣기 :   A B C        for+length 이용서 값 대입
//  3. for + length 로 출력 

