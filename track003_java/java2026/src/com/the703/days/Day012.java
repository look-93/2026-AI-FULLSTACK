package com.the703.days;

import java.util.Scanner;

public class Day012 {

	public static void main(String[] args) {
		int avg=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("평균입력 > ");
		avg = sc.nextInt();
		
		//1
		if(avg>=90) {
			System.out.println("A 학점");
		}else if(avg>=80) {
			System.out.println("B 학점");
		}else if(avg>=70) {
			System.out.println("C 학점");
		}else {
			System.out.println("F 학점");
		}
		
		//2
		switch(avg/10) {
		case 9: case 10: System.out.println("A 학점"); break;
		case 8: System.out.println("B 학점"); break;
		case 7: System.out.println("C 학점"); break;
		default: System.out.println("F 학점");
		}
		
		//3
		for(int i=1;i<=3;i++) {
			System.out.print(i);
		}		
		System.out.println();
		
		int i1=1;
		while(i1<=3) {
			System.out.print(i1);
			i1++;
		}		
		System.out.println();
		
		int i2=1;
		do {
			System.out.print(i2);
			i2++;
		}while(i2<=3);
		System.out.println();
		
		//4
		for(int i3=1;i3<=4;i3++) {
			for(int i4=1;i4<=4;i4++) {
				System.out.print("★");
			}
			System.out.println();
		}

	}

}
