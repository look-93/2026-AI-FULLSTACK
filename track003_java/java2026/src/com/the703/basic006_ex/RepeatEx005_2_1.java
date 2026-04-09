package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx005_2_1 {

	public static void main(String[] args) {
		//두개의 숫자를 입력받아 for문을 이용하여 다음과 같이 출력하시오	
		int num1=-1, num2=-1, sum=0, count=0;;
		String result="";
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자1입력 > ");
		num1 = sc.nextInt();
		System.out.print("숫자2입력 > ");
		num2 = sc.nextInt();
		
		for(;;) {
			if(num1 < num2) {
				sum = sum + num1 + count;
				result = result + (num1 + count); 
				count++;
//				System.out.println(num1);
//				System.out.println(num2);
				System.out.println(count);
				if(count==num2) break;	
			}else {
				sum = sum + num1 + count;				
				count --;
				if(count==num2) break;
			}	
			
		}
		System.out.println(result + "=" +sum);
	}

}
