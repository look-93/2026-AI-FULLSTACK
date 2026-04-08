package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx005_2 {

	public static void main(String[] args) {
		//두개의 숫자를 입력받아 for문을 이용하여 다음과 같이 출력하시오		
		int num1=0, num2=0, sum=0, count=0;;
		Scanner sc = new Scanner(System.in);
		
		String result="";
		
		System.out.print("숫자1입력 : "); 
		num1 = sc.nextInt();
		System.out.print("숫자2입력 : "); 
		num2 = sc.nextInt();	

		//for
		System.out.println("<for>");
		for(;;) {
			// 숫자1이 숫자2보다 작으면 숫자1부터 숫자2까지 덧셈
			if(num1 < num2) {
				result = result + (count + num1) + (num2-count != num1 ?"+":"");
				sum = sum + num1 + count;
				count++;
				if(count == num2) break;
			}else { 
				result = result + (num1 - count) + (num1-count != num2 ? "+" : "" );				
				sum = sum + num1 - count;
				count++;
				if(count == num1) break;
			}
		}	

		System.out.println(result+"="+sum);		
	}

}
