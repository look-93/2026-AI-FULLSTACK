package com.the703.basic006_ex;

public class RepeatEx004 {

	public static void main(String[] args) {
		//A~Z까지 다음과 같이 출력하시오
		int a=1;
		
		//for
		System.out.println("<for>");
		for(char ch1='A'; ch1<='Z'; ch1++) {
			System.out.print(ch1+(a%5==0?"\n":""));
			a++;
		}
		System.out.println();		
		
		//while
		System.out.println("<while>");
		a=1;
		char ch2='A';
		while(ch2<='Z') {
			System.out.print(ch2+(a%5==0?"\n":""));
			ch2++;
			a++;
		}
		System.out.println();
		
		//do while
		System.out.println("<do while>");
		a=1;
		char ch3='A';
		do {
			System.out.print(ch3+(a%5==0?"\n":""));
			a++;
			ch3++;
		}while(ch3<='Z');

	}

}
