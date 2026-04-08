package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx005_1 {

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
			for(int i=num1; i<=num2; i++) {					
				result = result + i + (i<num2?"+":"");
				sum = sum+i;
			}		
			for(int i=num1; i>=num2; i--) {					
				result = result + i + (i>num2?"+":"");
				sum = sum+i;
			}			
			break;
		}		
		System.out.println(result+"="+sum);
		
		//while
		result = "";
		sum=0;
		System.out.println("<while>");
		while(true) {
			for(int i=num1; i<=num2; i++) {					
				result = result + i + (i<num2?"+":"");
				sum = sum+i;
			}
			for(int i=num1; i>=num2; i--) {					
				result = result + i + (i>num2?"+":"");
				sum = sum+i;
			}		
			break;
		}
		System.out.println(result+"="+sum);
		
		//do while
		result = "";
		sum=0;
		System.out.println("<do while>");
		do {
			for(int i=num1; i<=num2; i++) {					
				result = result + i + (i<num2?"+":"");
				sum = sum+i;
			}
			for(int i=num1; i>=num2; i--) {					
				result = result + i + (i>num2?"+":"");
				sum = sum+i;
			}			
			break;
		}while(true);
		System.out.println(result+"="+sum);				

	}

}
