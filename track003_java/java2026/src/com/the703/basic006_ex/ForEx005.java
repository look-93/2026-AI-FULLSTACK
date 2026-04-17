package com.the703.basic006_ex;

public class ForEx005 {

	public static void main(String[] args) {
		int num = 0;
		
		for(char ch = 'a'; ch>='a' && ch <='z';ch++) {
			num = num+1;
		}
		System.out.println("소문자 a~z까지 모음의 갯수 : " + num);

	}

}

//연습문제5)  
//패키지명 : com.company.java005_ex
//클래스명 :  ForEx005
//출력내용 :   for 이용
//소문자 a~z까지 모음의 갯수를 출력하시오. 

//abcde
//fghij
//klmno
//pqrst
//uvwxy
//z == 26