package com.the703.days;

import java.util.Scanner;

public class Day011 {

	public static void main(String[] args) {
		char ch = '\u0000';
		Scanner sc = new Scanner(System.in);
		
		System.out.print("a,b,c 중에 입력 > ");
		ch = sc.next().charAt(0);
		
		//1
		if(ch == 'a') {
			System.out.println("apple");
		}else if(ch == 'b') {
			System.out.println("banana");
		}else if(ch == 'c') {
			System.out.println("coconut");
		}
		
		//2
		switch(ch) {
		case 'a': System.out.println("apple"); break;
		case 'b': System.out.println("banana"); break;
		case 'c': System.out.println("coconut"); break;
		}
		
		//3
		for(int i=1;i<=5;i++) {
			System.out.print(i+"\t");
		}		
		System.out.println();
		
		int i2=1;
		while(i2<=5) {
			System.out.print(i2+"\t");
			i2++;
		}		
		System.out.println();
		
		int i3=1;
		do {
			System.out.print(i3+"\t");
			i3++;
		}while(i3<=5);
		
	}

}
