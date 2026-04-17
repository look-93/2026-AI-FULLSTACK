package com.the703.days;

import java.util.Scanner;

public class Day014 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=0;
		System.out.print("숫자를 입력하세요 > ");
		num = sc.nextInt();
		
		//1.if
		if(num == 1) {
			System.out.println("1이다");
		}else if(num == 2) {
			System.out.println("2이다");
		}else if(num == 3) {
			System.out.println("3이다");
		}else {
			System.out.println("1,2,3이 아니다");
		}
		
		//2.switch
		switch(num) {
		case 1: System.out.println("1이다"); break;
		case 2: System.out.println("2이다"); break;
		case 3: System.out.println("3이다"); break;
		default: System.out.println("1,2,3이 아니다");
		}
		
		//3. 1 2 3 4
		//3-1 for
		for(int i=1;i<=4;i++) {
			System.out.print(i);
		}
		System.out.println();
		
		//3-2 while
		int i2=1;
		while(i2<=4) {
			System.out.print(i2);
			i2++;
		}
		System.out.println();
		
		//3-3 do while
		int i3=1;
		do {
			System.out.print(i3);
			i3++;			
		}while(i3<=4);
		System.out.println();
		
		//4. 이중for
		for(int i4=1;i4<=3;i4++) {
			for(int i5=1;i5<=i4;i5++) {
				System.out.print("★");
			}
			System.out.println();
		}
	
		//5. 
		int [] arr2 = {1,2,3};
		System.out.println(arr2[2]);
		
		//6.
		double [] arr3 = new double [5];
		double dou = 1.1;
		
		for(int i=0;i<arr3.length;i++) {
			arr3[i] = dou;
			dou = dou + 0.1;
			System.out.printf("%.1f \t",arr3[i]);
		}
		
	}
}
