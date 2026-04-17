package com.the703.basic006_ex;

public class RepeatEx003 {

	public static void main(String[] args) {
		
		//1~30의 범위에서 3의 배수이면서 2의 배수인 숫자와 갯수를 구하는 프로그램을 작성하시오.
		int num1=0, num2=0, num3=0;
		
		//for
		System.out.println("for");		
		for(int i1=1;i1<=30;i1++) {			
			if(i1%3==0 && i1%2==0) {				
				System.out.println((num1+1)+".3의 배수이면서 2의 배수인 숫자 : " + i1);
				num1 = num1+1;				
			}			
		}
		System.out.println("갯수 : "+num1);
		
		System.out.println();
		
		//while
		System.out.println("while");		
		int i2 = 1;
		while(i2<=30) {
			if(i2%3==0 && i2%2==0) {
				System.out.println((num2+1)+".3의 배수이면서 2의 배수인 숫자 : " + i2);
				num2 = num2+1;	
			}			
			i2++;
		}
		System.out.println("갯수 : "+num2);
		
		System.out.println();
		
		//do while
		System.out.println("do while");
		int i3 = 1;
		do {
			if(i3%3==0 && i3%2==0) {
				System.out.println((num3+1)+".3의 배수이면서 2의 배수인 숫자 : " + i3);
				num3 = num3+1;
			}
			i3++;
		}while(i3<=30);	
		System.out.println("갯수 : "+num3);
		
	}

}

