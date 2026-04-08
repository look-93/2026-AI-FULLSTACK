package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx005 {

	public static void main(String[] args) {
		//두개의 숫자를 입력받아 for문을 이용하여 다음과 같이 출력하시오		
		int num1=0, num2=0, sum=0;
		Scanner sc = new Scanner(System.in);
		String result="";
		
		System.out.print("숫자1입력 : ");
		num1 = sc.nextInt();
		System.out.print("숫자2입력 : ");
		num2 = sc.nextInt();	
		
		//for
		System.out.println("<for>");
		for(;;) {
//			if(num1<=num2) {						
//				result = result+num1;
//				sum = sum+num1;
//				num1++;				
//				continue;				
//			}
			if(num1>=num2) {						
				result = result+num1;
				sum = sum+num1;
				num1--;				
				continue;				
			}				
			break;		
		
		}		
		System.out.println(result+"="+sum);		
	}

}
