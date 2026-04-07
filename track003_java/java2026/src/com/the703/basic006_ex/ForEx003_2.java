package com.the703.basic006_ex;

public class ForEx003_2 {

	public static void main(String[] args) {
		//연습문제3_1 upgrade
		
		String result="";
		int sum=0;
		for(int i=1; i<=10; i++) {
			sum = sum+i;
			result = result+ (i==1 ? "" : "+")+i;
		}
		System.out.println(result+"="+sum);
	}

}

//연습문제3)  
//패키지명 : com.company.java005_ex
//클래스명 :  ForEx003
//출력내용 :   for 이용
//1~10까지의 합을 구하시오.
//
//upgrade)  시간나면 도전!
//1+2+3+4+5+6+7+8+9+10=55
